package com.example.filmleruygulamasi.data.datasource

import com.example.filmleruygulamasi.data.entity.FilmlerData
import com.example.filmleruygulamasi.data.retrofit.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao: FilmlerDao) {

    suspend fun filmleriYukle(): List<FilmlerData> =
        withContext(Dispatchers.IO) {

            return@withContext fdao.filmleriiYukle().filmler
        }

}