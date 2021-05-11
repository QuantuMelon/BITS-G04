package com.agiledeveloper.downbeat.ui.login

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
import com.agiledeveloper.downbeat.ui.createevent.CreateAccountsViewModel
import com.agiledeveloper.downbeat.ui.createevent.LoginViewModel
import java.io.File

class login : Fragment() {

    private lateinit var galleryViewModel: LoginViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_createevents, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        /*galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        //Handle Bottom Navigation Menu
        //Get the Nav Controller
        val navController = findNavController()
        //Get the "Buttons" - which are actually just Text

        val backbutton = root.findViewById<ImageView>(R.id.backbutton)
        //Handle button taps

        backbutton.setOnClickListener {
            navController.navigate(R.id.nav_home)
        }

        return root
    }



}
