package com.example.filmleruygulamasi.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

class FilmlerData(var id:Int,
                  var ad:String,
                  var resim:String,
                  var fiyat:Int):Serializable {
}