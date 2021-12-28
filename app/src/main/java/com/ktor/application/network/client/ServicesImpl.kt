package com.ktor.application.network.client

import com.ktor.application.network.Routes
import com.ktor.application.model.request.PostRequest
import com.ktor.application.model.response.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class ServicesImpl @Inject constructor(private val client: HttpClient) : Services {

    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(Routes.POSTS)
            }
        } catch (e: RedirectResponseException) {
            //3xx - responses
            println("Error:" + e.response.status.description)
            emptyList()
        } catch (e: ClientRequestException) {
            //4xx - responses
            println("Error:" + e.response.status.description)
            emptyList()
        } catch (e: ServerResponseException) {
            //5xx - responses
            println("Error:" + e.response.status.description)
            emptyList()
        } catch (e: Exception) {
            //5xx - responses
            println("Error:" + e.message)
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse> {
                url(Routes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            //3xx - responses
            println("Error:" + e.response.status.description)
            null
        } catch (e: ClientRequestException) {
            //4xx - responses
            println("Error:" + e.response.status.description)
            null
        } catch (e: ServerResponseException) {
            //5xx - responses
            println("Error:" + e.response.status.description)
            null
        } catch (e: Exception) {
            //5xx - responses
            println("Error:" + e.message)
            null
        }
    }

}