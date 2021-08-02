package com.omercankoc.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omercankoc.recyclerview.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    // Definition View Binding.
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding.
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /* Gelen veriyi Intent ile al.
        val intent = intent
        val selectedLanguage = intent.getSerializableExtra("language") as Languages
        binding.textViewLanguage.text = selectedLanguage.language
        binding.textViewYear.text = selectedLanguage.year.toString()
        binding.imageView.setImageResource(selectedLanguage.logo) */

        // Gelen veriyi Singleton ile al.
        val selectedLanguage = Singleton.chosenLanguage
        selectedLanguage?.let {
            binding.textViewLanguage.text = it.language
            binding.textViewYear.text = it.year.toString()
            binding.imageView.setImageResource(it.logo)
        }
    }
}