package com.agiledeveloper.downbeat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.view.MenuItem;
import android.widget.TextView
import android.widget.Toast;

// DownBeat Inception
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Login button
        val loginButton = findViewById<ImageButton>(R.id.btnLogin)


        //Handle button tap
        loginButton.setOnClickListener {
            setContentView(R.layout.event_page)
            eventsPage()
        }

    }

    //Moving everything EventsPage related into it's own function for now
    //Avoids error where setting an OnClickListener for an object not on current page crashes app
    fun eventsPage(){
        title = "Events Page"
        val eventButton = findViewById<TextView>(R.id.btnEvents)
        //Handle Events Button Click
        eventButton.setOnClickListener {
            setContentView(R.layout.activity_main)
        }
    }


}
//Declan
//Gregory
//Brandon
//Rebecca
