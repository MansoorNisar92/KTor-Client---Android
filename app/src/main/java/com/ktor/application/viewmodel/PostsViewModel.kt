package com.ktor.application.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktor.application.Event
import com.ktor.application.extensions.inverse
import com.ktor.application.model.response.PostResponse
import com.ktor.application.client.Services
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class PostsViewModel @Inject constructor(@Named("Services") private val servicesImpl: Services) : ViewModel(){
    val progressLiveData = MutableLiveData<Event<Boolean>>()
    val errorMessageLiveData = MutableLiveData<String>()
    private val _postsStateFlow = MutableStateFlow(arrayListOf<PostResponse>())
    val postsStateFlow = _postsStateFlow.asStateFlow()
    fun fetchPosts(){
        progressLiveData.postValue(Event(true))
        viewModelScope.launch {
            val posts = servicesImpl.getPosts()
            if (posts.isNullOrEmpty().inverse){
                progressLiveData.postValue(Event(false))
                _postsStateFlow.value = posts as ArrayList<PostResponse>
            }else{
                progressLiveData.postValue(Event(false))
                errorMessageLiveData.postValue("Something went wrong")
            }
        }
    }

}