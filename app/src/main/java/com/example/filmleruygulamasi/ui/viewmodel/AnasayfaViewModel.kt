package com.example.filmleruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmleruygulamasi.data.entity.FilmlerData
import com.example.filmleruygulamasi.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor( var frs:FilmlerRepository):ViewModel() {

    var filmler=MutableLiveData<List<FilmlerData>>()

    init {
        filmleriYukle()
    }

     fun filmleriYukle() {
         CoroutineScope(Dispatchers.Main).launch {
            filmler.value= frs.filmleriYukle()
         }

     }
}