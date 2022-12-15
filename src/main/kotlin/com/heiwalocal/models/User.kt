package com.heiwalocal.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String
)
