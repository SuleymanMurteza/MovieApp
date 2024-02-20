package com.example.filmleruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmleruygulamasi.data.entity.FilmlerData
import com.example.filmleruygulamasi.databinding.CardTasarimBinding
import com.example.filmleruygulamasi.ui.fragments.FilmlerFragmentDirections
import com.example.filmleruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class Adapter(var mContext:Context, var filmler_Listesi: List<FilmlerData>,var viewModel: AnasayfaViewModel)
    :RecyclerView.Adapter<Adapter.cardTasarimTutucu>() {


    inner class cardTasarimTutucu(var binding:CardTasarimBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val binding =CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
            return cardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return filmler_Listesi.size
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film=filmler_Listesi.get(position)
        val t=holder.binding

      val url="http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(400,600).into(t.imageViewCard)

        t.textView.text="${film.fiyat} ₺"

        t.cardView.setOnClickListener {
            val gecis=FilmlerFragmentDirections.gecisDetay(filmler=film)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.button.setOnClickListener {
            Snackbar.make(it,"${film.ad} Sepete Eklendi",Snackbar.LENGTH_SHORT).show()
        }
    }

}

