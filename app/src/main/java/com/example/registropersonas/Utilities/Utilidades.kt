package com.example.registropersonas.Utilities

import android.text.Editable

fun Editable?.getInt(): Int {
    return this.toString().toIntOrNull() ?: 0
}

fun Editable?.getFloat(): Float {
    return this.toString().toFloatOrNull() ?: 0f
}

