package com.ktor.application.client

import com.ktor.application.extensions.convertJsonToModel
import com.ktor.application.extensions.getJsonContent
import com.ktor.application.model.request.PostRequest
import com.ktor.application.model.response.PostResponse
import javax.inject.Inject

class FakeServiceImpl @Inject constructor(): Services {

    override suspend fun getPosts(): List<PostResponse> {
        when {
            shouldReturnEmpty -> {
                return emptyList()
            }
            shouldReturnError -> {
                return emptyList()
            }
            else -> {
                val successResponse = "api_success_response.json".getJsonContent()
                convertJsonToModel<ArrayList<PostResponse>>(successResponse)?.let {
                    return it
                }
            }
        }
        return emptyList()
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        TODO("Not yet implemented")
    }



    private var shouldReturnError = false
    private var shouldReturnEmpty = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    fun setReturnEmpty(value: Boolean) {
        shouldReturnError = value
    }
}