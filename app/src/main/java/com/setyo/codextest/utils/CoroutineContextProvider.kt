package com.setyo.codextest.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
//    open val IO: CoroutineContext by lazy { CommonPool }
}