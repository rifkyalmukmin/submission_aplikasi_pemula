package com.example.tour_bandung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tour_bandung.databinding.ActivityMyAboutBinding

class MyAbout : AppCompatActivity() {

    private lateinit var binding: ActivityMyAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}