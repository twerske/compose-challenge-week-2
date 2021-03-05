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

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(timeViewModel: TimeViewModel = viewModel()) {
    Surface(color = MaterialTheme.colors.background) {
        TimeDisplay(timeViewModel)
    }
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@RequiresApi(Build.VERSION_CODES.O)
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeDisplay(viewModel: TimeViewModel) {
    val time: Long by viewModel.time.observeAsState(300000L)
    val countdown = object : CountDownTimer(time, 1000) {
        override fun onTick(l: Long) {
            viewModel.onTimeChanged(l)
        }

        override fun onFinish() {

        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        val m = viewModel.getMinutes()
        val s = viewModel.getSeconds()

        Text(
            text = "$m : $s",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = time.toString(),
            onValueChange = {
                countdown.cancel()
                viewModel.onTimeChanged(it.toLong())
            },
            label = { Text("Countdown Time") }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { countdown.start() }) {
                Text(text = "START")
            }
            Button(onClick = { countdown.start() }) {
                Text(text = "PAUSE")
            }
            Button(onClick = { countdown.cancel() }) {
                Text(text = "CANCEL")
            }
        }
    }
}

class TimeViewModel : ViewModel() {
    private val _time = MutableLiveData(300000L)
    val time: LiveData<Long> = _time

    fun onTimeChanged(newTime: Long) {
        _time.value = newTime
    }

    fun getMinutes(): Long {
        return (_time.value!! / 1000) / 60
    }

    fun getSeconds(): Long {
        return (_time.value!! / 1000) % 60
    }

//    fun getYears() {
//        return (_time.value / 1000) / 60
//    }

//    fun getMonths() {
//        return (_time.value / 1000) / 60
//    }

//    fun getDays() {
//        return (_time.value / 1000) / 60
//    }

//    fun getHours() {
//        return (_time.value / 1000) / 60
//    }
}
