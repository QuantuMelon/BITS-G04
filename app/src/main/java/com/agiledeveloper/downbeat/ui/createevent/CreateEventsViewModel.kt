package com.agiledeveloper.downbeat.ui.createevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateEventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Create Events Page"
    }
    val text: LiveData<String> = _text
}