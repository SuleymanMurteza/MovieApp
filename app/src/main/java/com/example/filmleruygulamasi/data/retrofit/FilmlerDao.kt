package com.example.filmleruygulamasi.data.retrofit

import androidx.room.Dao
import androidx.room.Query
import com.example.filmleruygulamasi.data.entity.FilmlerCevap
import com.example.filmleruygulamasi.data.entity.FilmlerData
import retrofit2.http.GET


interface FilmlerDao {
    //http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php
    //http://kasimadalan.pe.hu/ -> base url
    //filmler_yeni/tum_filmler.php -> webservis url

    @GET("filmler_yeni/tum_filmler.php")//bizden webservis bilgi istemiyor o yğzden get yöntemi kullandık.
    suspend fun filmleriiYukle() : FilmlerCevap

}