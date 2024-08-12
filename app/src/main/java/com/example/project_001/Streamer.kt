package com.example.project_001

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Streamer(
    val name: String,
    val description: String,
    val image: Int
) : Parcelable