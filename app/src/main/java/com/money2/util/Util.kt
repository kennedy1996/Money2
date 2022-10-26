package com.money2.util

fun convertToScale(input: Double) = String.format("%.${2}f", input)