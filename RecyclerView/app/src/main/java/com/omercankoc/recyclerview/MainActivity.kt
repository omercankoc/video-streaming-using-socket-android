package com.omercankoc.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.omercankoc.recyclerview.databinding.ActivityDetailsBinding
import com.omercankoc.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Definition View Binding.
    private lateinit var binding: ActivityMainBinding

    // Definition ArrayList Languages.
    private lateinit var languagesList : ArrayList<Languages>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize ArrayList Languages.
        languagesList = ArrayList<Languages>()

        // Language nesneleri olustur.
        val kotlin = Languages("Kotlin",2011,R.drawable.kotlin)
        val swift = Languages("Swift",2014,R.drawable.swift)
        val rust = Languages("Rust",2012,R.drawable.rust)
        val go = Languages("Go",2009,R.drawable.go)

        // Olusturulan nesneleri listeye ekle.
        languagesList.add(kotlin)
        languagesList.add(swift)
        languagesList.add(rust)
        languagesList.add(go)

        // Itemleri dikey konumda goruntule.
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // Adapter nesnesi olustur.
        val languageAdapter = RecycleViewAdapter(languagesList)
        // View ile adapter'i bagla.
        binding.recyclerView.adapter = languageAdapter
    }
}