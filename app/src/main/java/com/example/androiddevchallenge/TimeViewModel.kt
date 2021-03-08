/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimeViewModel : ViewModel() {
    private val _isRunning = MutableLiveData(false)
    val isRunning: LiveData<Boolean> = _isRunning

    private val _time = MutableLiveData(300000L)
    val time: LiveData<Long> = _time

    fun toggleIsRunning() {
        _isRunning.value = !_isRunning.value!!
    }

    fun onTimeChanged(newTime: Long) {
        _time.value = newTime
    }

    fun getMinutes(): String {
        return ((_time.value!! / 1000) / 60).toString()
    }

    fun getSeconds(): String {
        return ((_time.value!! / 1000) % 60)
            .toString()
            .padStart(2, '0')
    }

//    fun getHours() {
//        return (_time.value / 1000) / 60
//    }

//    fun getDays() {
//        return (_time.value / 1000) / 60
//    }

//    fun getMonths() {
//        return (_time.value / 1000) / 60
//    }

//    fun getYears() {
//        return (_time.value / 1000) / 60
//    }
}
