package com.example.tour_bandung

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tour_bandung.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataTour = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_TOUR, Tour::class.java)
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_TOUR)
        }
        if (dataTour != null) {
            binding.IvImg.setImageResource(dataTour.photo)
            binding.tvTitle.text = dataTour.name
            binding.tvDescription.text = dataTour.description
        }
    }

    companion object {

        const val EXTRA_TOUR = "extra_tour"
    }
}