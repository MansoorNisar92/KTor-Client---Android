package com.ktor.application.data.network.client

import com.ktor.application.model.request.PostRequest
import com.ktor.application.model.response.PostResponse

interface Services {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?
}