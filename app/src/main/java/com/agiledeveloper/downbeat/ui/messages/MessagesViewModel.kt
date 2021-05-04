package com.agiledeveloper.downbeat.ui.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Messages Page"
    }
    val text: LiveData<String> = _text
}