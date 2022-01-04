package com.ktor.application.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.ktor.application.R
import java.io.InputStreamReader

const val EMPTY_STRING = ""


fun <T> List<T>?.orEmptyArrayList(): ArrayList<T> = emptyIfNull as ArrayList<T>

val <T> List<T>?.emptyIfNull
    get() = this ?: arrayListOf()

val Boolean.inverse
    get() = not()

val Boolean?.toString
    get() = if (this == null || this == false) "0" else "1"

val Boolean?.default
    get() = this ?: false



inline fun <T : Any> T?.nonNull(action: T.() -> Unit) = this?.apply { action(this) }

fun uniqueNumber(): String {
    var fourDigitNumber  = ""
    val rangeList = {(0..9).random()}

    while (fourDigitNumber.length < 4) {
        val num = rangeList().toString()
        if (!fourDigitNumber.contains(num)) fourDigitNumber += num
    }

    return fourDigitNumber
}

fun Fragment.showSnackBar(message: String) = view?.let {
    Snackbar.make(it,message, Snackbar.LENGTH_LONG).show()
}

fun Activity.showSnackBar(message: String) = this.let {
    val view = it.findViewById<View>(R.id.content)
    Snackbar.make(view,message, Snackbar.LENGTH_LONG).show()
}


fun View.hideKeyboard() {
    (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
        windowToken,
        0
    )
}

fun EditText.clearFocusAndHideKeyboard(){
    hideKeyboard()
    clearFocus()
}

fun AppCompatEditText.clearFocusAndHideKeyboard(){
    hideKeyboard()
    clearFocus()
}

fun Context.navigateToAppSettings() {
    startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        data = Uri.fromParts("package", packageName, null)
    })
}

fun String.getJsonContent(): String {
    return InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(this)).use { it.readText() }
}

fun <T> convertObjectToJsonString(model: T): String = Gson().toJson(model)

inline fun <reified T> convertJsonToModel(string: String): T? = Gson().fromJson(string, T::class.java)
