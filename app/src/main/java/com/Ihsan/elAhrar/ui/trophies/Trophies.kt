package com.Ihsan.elAhrar.ui.trophies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Ihsan.elAhrar.R

class Trophies : Fragment() {

    companion object {
        fun newInstance() = Trophies()
    }

    private lateinit var viewModel: TrophiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trophies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrophiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}