package com.example.filmleruygulamasi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.filmleruygulamasi.R
import com.example.filmleruygulamasi.databinding.FragmentFilmlerBinding
import com.example.filmleruygulamasi.ui.adapter.Adapter
import com.example.filmleruygulamasi.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmlerFragment : Fragment() {
    private lateinit var binding:FragmentFilmlerBinding
    private lateinit var viewModel:AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_filmler,container,false)

        binding.toolbarBaslik="Filmler"

        viewModel.filmler.observe(viewLifecycleOwner){
            val filmlerAdapter=Adapter(requireContext(),it,viewModel )
            binding.filmlerAdapter=filmlerAdapter

        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

}