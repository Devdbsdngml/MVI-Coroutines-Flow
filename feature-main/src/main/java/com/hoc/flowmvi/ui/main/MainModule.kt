package com.hoc.flowmvi.ui.main

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

@JvmField
@ExperimentalCoroutinesApi
@FlowPreview
val mainModule =
  module {
    viewModelOf(::MainVM)
  }
