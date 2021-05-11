package com.agiledeveloper.downbeat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.agiledeveloper.downbeat.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        //Login button directs to Events page
        //Get the Nav Controller
        val navController = findNavController()
        //Get the loginButton
        val loginButton = root.findViewById<ImageButton>(R.id.btnLogin)
        //Get the createAccount button
        val createAccountButton = root.findViewById<ImageButton>(R.id.btnCreateAccount)
         //Handle button tap
        loginButton.setOnClickListener {
             navController.navigate(R.id.nav_login)
         }

        createAccountButton.setOnClickListener {
            navController.navigate(R.id.nav_createaccount)
        }
        return root
    }
}