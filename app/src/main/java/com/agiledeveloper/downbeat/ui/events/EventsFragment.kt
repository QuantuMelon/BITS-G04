package com.agiledeveloper.downbeat.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.agiledeveloper.downbeat.R
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.NullPointerException

class EventsFragment : Fragment() {

    private lateinit var galleryViewModel: EventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(EventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        //galleryViewModel.text.observe(viewLifecycleOwner, Observer {
        //   textView.text = it
        // })
        //Handle Bottom Navigation Menu
        //Get the Nav Controller
        val navController = findNavController()
        //Get the "Buttons" - which are actually just Text
        val eventsButton = root.findViewById<Button>(R.id.eventsbutton)
        val mapsButton = root.findViewById<Button>(R.id.mapsbutton)
        //Handle button taps
        eventsButton.setOnClickListener {
            navController.navigate(R.id.nav_events)
        }
        mapsButton.setOnClickListener {
            navController.navigate(R.id.nav_maps)
        }

        //Read Events from file
        readFile(root)



        return root
    }

    fun readFile(root: View) {

        try {
            var venue: String = ""
            var date: String = ""
            val eventTitle1: TextView = root.findViewById(R.id.eventTitle1)
            val eventDate1: TextView = root.findViewById(R.id.eventDate1)
            val fileInputStream: FileInputStream? = context?.openFileInput("events.txt")
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuffer = StringBuffer()
            var lines: String = ""
            lines = bufferedReader.readLine()
            /*while (lines != null) {
                val tokens = lines.split(",")
                venue = tokens[1]
                date = tokens[3]
                if (bufferedReader.readLine())
                lines = bufferedReader.readLine()
            }*/
            bufferedReader.forEachLine {
                lines = bufferedReader.readLine()
                val tokens = lines.split(",")
                venue = tokens[1]
                date = tokens[3]
            }
            eventTitle1.setText(venue).toString()
            eventDate1.setText(date).toString()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}