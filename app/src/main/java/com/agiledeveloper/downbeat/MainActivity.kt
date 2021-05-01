package com.agiledeveloper.downbeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


// DownBeat Inception
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Login button
        val loginButton = findViewById<ImageButton>(R.id.btnLogin)

        //Handle button tap
        loginButton.setOnClickListener { setContentView(R.layout.event_page) }

    }
}
//Declan
//Gregory
//Brandon
//Rebecca
