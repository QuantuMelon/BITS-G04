package com.agiledeveloper.downbeat.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.agiledeveloper.downbeat.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class MapsFragment : Fragment() {

    //lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap
    private lateinit var mapsViewModel: MapsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { mapsViewModel =
        ViewModelProvider(this).get(MapsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_maps, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
        initilizeMap();
/*        mapFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
        })*/

        return root
    }

    private fun initilizeMap() {
        val mapFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        if (mapFragment != null) {
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it
            })
            if (googleMap != null) googleMap.setOnMapClickListener {
                //TODO: your onclick stuffs
            }
        }
    }
}






