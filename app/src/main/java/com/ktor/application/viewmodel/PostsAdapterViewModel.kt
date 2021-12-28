package com.ktor.application.viewmodel

import androidx.lifecycle.ViewModel
import com.ktor.application.model.response.PostResponse

class PostsAdapterViewModel(
    val postResponse: PostResponse,
) : ViewModel() {

}