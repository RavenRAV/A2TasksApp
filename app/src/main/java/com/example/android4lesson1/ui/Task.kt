package com.example.android4lesson1.ui

import java.io.Serializable

data class Task(
    var title: String,
    var description: String
) : Serializable
