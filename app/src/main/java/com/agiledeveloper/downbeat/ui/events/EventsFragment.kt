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
import java.io.*

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        eventsViewModel =
            ViewModelProvider(this).get(EventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        //Get the Nav Controller
        val navController = findNavController()
        //Get the bottom nav "Buttons"
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

/*            val N = 10 // total number of textviews to add
            val myTextViews = arrayOfNulls<TextView>(N) // create an empty array;


            for (i in 0 until N) {
                // create a new textview
                val rowTextView = TextView(this)

                // set some properties of rowTextView or something
                rowTextView.text = "This is row #$i"

                // add the textview to the linearlayout
                myLinearLayout.addView(rowTextView)

                // save a reference to the textview for later
                myTextViews[i] = rowTextView
            }*/
            //var count = -1;
            bufferedReader.forEachLine {
                //count++
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
        } finally {
            //fileInputStream
            //inputStreamReader
            //bufferedReader.close
        }
    }
}