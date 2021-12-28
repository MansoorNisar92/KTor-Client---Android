package com.ktor.application

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:loadLazyImage")
    fun loadLazyImage(
        appCompatImageView: AppCompatImageView,
        url:String) {
        appCompatImageView.apply {


        }
    }

}