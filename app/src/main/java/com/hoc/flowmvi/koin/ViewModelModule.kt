package com.hoc.flowmvi.koin

import com.hoc.flowmvi.ui.MainVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
  viewModel { MainVM(get(), get()) }
}