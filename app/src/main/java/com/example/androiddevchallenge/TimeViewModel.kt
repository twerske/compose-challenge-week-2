package com.example.androiddevchallenge

import android.os.CountDownTimer
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