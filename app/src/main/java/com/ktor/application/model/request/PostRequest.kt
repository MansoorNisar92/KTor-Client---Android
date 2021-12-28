package com.ktor.application.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val userId: Int,
    val title: String,
    val body: String,
)
