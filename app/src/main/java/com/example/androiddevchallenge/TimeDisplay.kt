package com.example.androiddevchallenge

import android.os.Build
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val m = viewModel.getMinutes()
        val s = viewModel.getSeconds()

        Text(
            text = "$m : $s",
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.White,
            style = MaterialTheme.typography.h1
        )

        ControlsRow(
            viewModel,
            countdown
        )
    }
}