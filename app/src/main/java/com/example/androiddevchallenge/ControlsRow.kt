package com.example.androiddevchallenge

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.PauseCircle
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ControlsRow(
    viewModel: TimeViewModel,
    countdown: CountDownTimer
) {
    val isRunning: Boolean by viewModel.isRunning.observeAsState(false)

    Row(
//        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        if (isRunning) {
            IconButton(
                modifier = Modifier.then(Modifier.size(48.dp)),
                onClick = {
                    viewModel.toggleIsRunning()
                    countdown.cancel()
                }) {
                Icon(
                    Icons.Outlined.PauseCircle, "Pause",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                )
            }
        } else {
            IconButton(
                modifier = Modifier.then(Modifier.size(48.dp)),
                onClick = {
                    viewModel.toggleIsRunning()
                    countdown.start()
                }) {
                Icon(
                    Icons.Outlined.PlayCircle, "Start",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                )
            }

            IconButton(
                modifier = Modifier.then(Modifier.size(48.dp)),
                onClick = {
                    // TODO
                }) {
                Icon(
                    Icons.Outlined.Edit, "Edit",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                )
            }

            IconButton(
                modifier = Modifier.then(Modifier.size(48.dp)),
                onClick = {
                    viewModel.toggleIsRunning()
                    countdown.cancel()
                    viewModel.onTimeChanged(1000L)
                }) {
                Icon(
                    Icons.Outlined.RestartAlt, "Reset",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                )
            }
        }
    }
}