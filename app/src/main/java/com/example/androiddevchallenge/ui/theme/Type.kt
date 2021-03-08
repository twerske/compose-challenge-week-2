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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.androiddevchallenge.R

val Acme = FontFamily(
    Font(R.font.acme_regular)
)

private val defaultTypography = Typography()
val typography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = Acme),
    h2 = defaultTypography.h2.copy(fontFamily = Acme),
    h3 = defaultTypography.h3.copy(fontFamily = Acme),
    h4 = defaultTypography.h4.copy(fontFamily = Acme),
    h5 = defaultTypography.h5.copy(fontFamily = Acme),
    h6 = defaultTypography.h6.copy(fontFamily = Acme),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = Acme),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = Acme),
    body1 = defaultTypography.overline.copy(fontFamily = Acme),
    body2 = defaultTypography.overline.copy(fontFamily = Acme),
    button = defaultTypography.overline.copy(fontFamily = Acme),
    caption = defaultTypography.overline.copy(fontFamily = Acme),
    overline = defaultTypography.overline.copy(fontFamily = Acme)
)
