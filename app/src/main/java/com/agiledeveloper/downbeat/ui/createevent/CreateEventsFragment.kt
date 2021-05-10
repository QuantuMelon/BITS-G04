package com.agiledeveloper.downbeat.ui.createevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.agiledeveloper.downbeat.R
import java.io.File

class CreateEventsFragment : Fragment() {

    private lateinit var galleryViewModel: CreateEventsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(CreateEventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_createevents, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        /*galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

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


        val fileName = "events.txt"
        val eventsFile = File(fileName)

        lateinit var createButton: ImageView
        lateinit var typeInput: Spinner
        lateinit var titleInput: EditText
        lateinit var contactInput: EditText
        lateinit var locationInput: EditText
        lateinit var dateInput: EditText
        lateinit var startTimeInput: EditText
        lateinit var endTimeInput: EditText
        lateinit var feeInput: EditText
        lateinit var descriptionInput: EditText
        lateinit var instrumentsInput: CheckBox
        lateinit var socialInput: CheckBox
        lateinit var type: String
        lateinit var title: String
        lateinit var contact: String
        lateinit var location: String
        lateinit var date: String
        lateinit var startTime: String
        lateinit var endTime: String
        lateinit var fee: String
        lateinit var description: String
        lateinit var instruments: String
        lateinit var postSocial: String

            //Maybe create a popup box here?
            //setContentView(R.layout.activity_main)
            //title = "KotlinApp"
            createButton = root.findViewById(R.id.createButtonBackground)
            typeInput = root.findViewById(R.id.typeSpinner)
            titleInput = root.findViewById(R.id.titleInput)
            contactInput = root.findViewById(R.id.contactInput)
            locationInput = root.findViewById(R.id.locationInput)
            dateInput = root.findViewById(R.id.dateInput)
            startTimeInput = root.findViewById(R.id.startTimeInput)
            endTimeInput = root.findViewById(R.id.endTimeInput)
            feeInput = root.findViewById(R.id.feeInput)
            descriptionInput = root.findViewById(R.id.descriptionInput)
            instrumentsInput = root.findViewById(R.id.ownInstrumentsInput )
            socialInput = root.findViewById(R.id.postToSocialInput  )
            createButton.setOnClickListener {
                type = typeInput.toString()
                title = titleInput.toString()
                contact = contactInput.toString()
                location = locationInput.toString()
                date = dateInput.toString()
                startTime = startTimeInput.toString()
                endTime = endTimeInput.toString()
                fee = feeInput.toString()
                description = descriptionInput.toString()
                instruments = instrumentsInput.toString()
                postSocial = socialInput.toString()

                //textView.text = string

                //Print to file
                eventsFile.printWriter().use { out ->
                    out.println(type + "," + title + "," + contact + "," + location + "," + date + ","
                            + startTime + "," + endTime + "," + fee + "," + description + "," + instruments + "," + postSocial)
                }
            }

        return root
    }



}
