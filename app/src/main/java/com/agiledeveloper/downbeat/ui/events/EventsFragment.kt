package com.agiledeveloper.downbeat.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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
            val eventBackground1: ImageView = root.findViewById(R.id.eventBackground1)
            val eventTitle2: TextView = root.findViewById(R.id.eventTitle2)
            val eventDate2: TextView = root.findViewById(R.id.eventDate2)
            val eventBackground2: ImageView = root.findViewById(R.id.eventBackground2)
            val eventTitle3: TextView = root.findViewById(R.id.eventTitle3)
            val eventDate3: TextView = root.findViewById(R.id.eventDate3)
            val eventBackground3: ImageView = root.findViewById(R.id.eventBackground3)
            val eventTitle4: TextView = root.findViewById(R.id.eventTitle4)
            val eventDate4: TextView = root.findViewById(R.id.eventDate4)
            val eventBackground4: ImageView = root.findViewById(R.id.eventBackground4)
            val eventTitle5: TextView = root.findViewById(R.id.eventTitle5)
            val eventDate5: TextView = root.findViewById(R.id.eventDate5)
            val eventBackground5: ImageView = root.findViewById(R.id.eventBackground5)
            val fileInputStream: FileInputStream? = context?.openFileInput("events.txt")
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuffer = StringBuffer()
            var lines: String = ""

            //Loop through file until readLine returns null
            //Hardcoding 5 to be the maximum amount of events read from file.
            var count = 0
            while (count < 5) {
                lines = bufferedReader.readLine() ?: break
                val tokens = lines.split(",")
                venue = tokens[1]
                date = tokens[3]
                if (count == 0) {
                    eventBackground1.visibility = View.VISIBLE
                    eventTitle1.visibility = View.VISIBLE
                    eventDate1.visibility = View.VISIBLE
                    eventTitle1.setText(venue).toString()
                    eventDate1.setText(date).toString()
                } else if (count == 1){
                    eventBackground2.visibility = View.VISIBLE
                    eventTitle2.visibility = View.VISIBLE
                    eventDate2.visibility = View.VISIBLE
                    eventTitle2.setText(venue).toString()
                    eventDate2.setText(date).toString()
                } else if (count == 2){
                    eventBackground3.visibility = View.VISIBLE
                    eventTitle3.visibility = View.VISIBLE
                    eventDate3.visibility = View.VISIBLE
                    eventTitle3.setText(venue).toString()
                    eventDate3.setText(date).toString()
                } else if (count == 3){
                    eventBackground4.visibility = View.VISIBLE
                    eventTitle4.visibility = View.VISIBLE
                    eventDate4.visibility = View.VISIBLE
                    eventTitle4.setText(venue).toString()
                    eventDate4.setText(date).toString()
                } else if (count == 4){
                    eventBackground5.visibility = View.VISIBLE
                    eventTitle5.visibility = View.VISIBLE
                    eventDate5.visibility = View.VISIBLE
                    eventTitle5.setText(venue).toString()
                    eventDate5.setText(date).toString()
                }
                count++
            }


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