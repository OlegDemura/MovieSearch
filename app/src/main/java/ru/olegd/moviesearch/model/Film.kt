package ru.olegd.moviesearch.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(val title: String, val description: String, val image: Int) : Parcelable