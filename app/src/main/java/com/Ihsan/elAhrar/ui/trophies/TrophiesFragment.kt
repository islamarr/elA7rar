package com.Ihsan.elAhrar.ui.trophies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Ihsan.elAhrar.R

class TrophiesFragment : Fragment() {

    companion object {
        fun newInstance() = TrophiesFragment()
    }

    private lateinit var viewModel: TrophiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trophies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrophiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}