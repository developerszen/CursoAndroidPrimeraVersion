package com.zentechnology.navigationdrawer.ui


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.zentechnology.navigationdrawer.PrimerActivity

import com.zentechnology.navigationdrawer.R

/**
 * A simple [Fragment] subclass.
 */
class NuevoFragment : Fragment() {

    lateinit var btnLanzarActivity : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_nuevo, container, false)

        btnLanzarActivity = view.findViewById(R.id.btnLanzarActivity)

        btnLanzarActivity.setOnClickListener{
            val intent = Intent(activity, PrimerActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}
