package com.example.filmleruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.example.filmleruygulamasi.data.datasource.FilmlerDataSource
import com.example.filmleruygulamasi.data.repo.FilmlerRepository
import com.example.filmleruygulamasi.data.retrofit.ApiUtils
import com.example.filmleruygulamasi.data.retrofit.FilmlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFilmlerDataSource(fdao: FilmlerDao):FilmlerDataSource{
        return FilmlerDataSource(fdao)
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource):FilmlerRepository{
        return FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao(): FilmlerDao {
        return ApiUtils.getFilmlerDao()
    }

}