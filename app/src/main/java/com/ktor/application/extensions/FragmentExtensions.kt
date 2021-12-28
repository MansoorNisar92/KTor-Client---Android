package com.ktor.application.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(navDirections: NavDirections?) {
    navDirections?.let {
        findNavController().navigate(navDirections)
    }
}

fun Fragment.navigateBack() {
    findNavController().popBackStack()
}


