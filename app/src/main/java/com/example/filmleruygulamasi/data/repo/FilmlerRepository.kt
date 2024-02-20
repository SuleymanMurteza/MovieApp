package com.example.filmleruygulamasi.data.repo

import com.example.filmleruygulamasi.data.entity.FilmlerData
import com.example.filmleruygulamasi.data.datasource.FilmlerDataSource

class FilmlerRepository(var fds:FilmlerDataSource){



    suspend fun filmleriYukle(): List<FilmlerData> =fds.filmleriYukle()
}