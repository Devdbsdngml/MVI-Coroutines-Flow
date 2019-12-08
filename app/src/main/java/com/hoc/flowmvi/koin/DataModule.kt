package com.hoc.flowmvi.koin

import com.hoc.flowmvi.data.UserDomainToUserResponseMapper
import com.hoc.flowmvi.data.UserResponseToUserDomainMapper
import com.hoc.flowmvi.data.remote.UserApiService
import com.hoc.flowmvi.data.remote.UserResponse
import com.hoc.flowmvi.domain.Mapper
import com.hoc.flowmvi.domain.entity.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "BASE_URL"

val dataModule = module {
  single { UserApiService(get()) }

  single { UserResponseToUserDomainMapper() }

  single { UserDomainToUserResponseMapper() }

  single { provideRetrofit(get(named(BASE_URL)), get()) }

  single { provideMoshi() }

  single(named(BASE_URL)) { "https://5caad70369c15c001484956a.mockapi.io/hoc081098/" }
}

private fun provideMoshi(): Moshi {
  return Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
}

private fun provideRetrofit(baseUrl: String, moshi: Moshi): Retrofit {
  return Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseUrl)
    .build()
}