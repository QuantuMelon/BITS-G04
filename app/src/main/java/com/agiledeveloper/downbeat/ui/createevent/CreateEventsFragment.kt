package com.agiledeveloper.downbeat.ui.createevent

import android.content.Context
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

        titleInput = root.findViewById(R.id.titleInput)
        contactInput = root.findViewById(R.id.contactInput)
        locationInput = root.findViewById(R.id.locationInput)
        dateInput = root.findViewById(R.id.dateInput)
        startTimeInput = root.findViewById(R.id.startTimeInput)
        endTimeInput = root.findViewById(R.id.endTimeInput)
        feeInput = root.findViewById(R.id.feeInput)
        descriptionInput = root.findViewById(R.id.descriptionInput)
        instrumentsInput = root.findViewById(R.id.ownInstrumentsInput)
        socialInput = root.findViewById(R.id.postToSocialInput)

        typeInput = root.findViewById(R.id.typeSpinner)
        ArrayAdapter.createFromResource(requireContext(), R.array.eventTypes, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            typeInput.adapter = adapter

        }

        createButton.setOnClickListener {
            type = typeInput.selectedItem.toString()
            title = titleInput.getText().toString()
            contact = contactInput.getText().toString()
            location = locationInput.getText().toString()
            date = dateInput.getText().toString()
            startTime = startTimeInput.getText().toString()
            endTime = endTimeInput.getText().toString()
            fee = feeInput.getText().toString()
            description = descriptionInput.getText().toString()
            if (instrumentsInput.isChecked()) {
                instruments = "true"
            } else {
                instruments = "false"
            }
            if (socialInput.isChecked()) {
                postSocial = "true"
            } else {
                postSocial = "false"
            }

            val event = type + "," + title + "," + location + "," + date + "," + startTime + "," + endTime + "," + fee + "," + contact + "," + description + "," + instruments + "," + postSocial + "\n"
            val fileName = "events.txt"

            //Print to file
            context?.openFileOutput(fileName, Context.MODE_APPEND).use {
                if (it != null) {
                    it.write(event.toByteArray())
                }
            }
        }

        return root
    }


}