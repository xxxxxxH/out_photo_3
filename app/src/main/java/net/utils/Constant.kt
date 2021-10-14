package net.utils

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi

object Constant {
    @RequiresApi(Build.VERSION_CODES.R)
    val permissions = arrayOf(
        Manifest.permission.MANAGE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )
    const val TYPE = "type"
    const val DATA = "data"
}