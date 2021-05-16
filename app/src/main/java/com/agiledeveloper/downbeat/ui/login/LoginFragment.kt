package com.agiledeveloper.downbeat.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.agiledeveloper.downbeat.R

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
                ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        //Login button directs to Events page
        //Get the Nav Controller
        val navController = findNavController()
        //Get the loginButton
        val backButton = root.findViewById<ImageView>(R.id.backbutton)
        //Handle button taps

        backButton.setOnClickListener {
            navController.navigate(R.id.nav_home)
        }

        return root
    }
}