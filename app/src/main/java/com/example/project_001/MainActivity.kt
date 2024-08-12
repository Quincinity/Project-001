package com.example.project_001

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvStreamers: RecyclerView
    private val list = ArrayList<Streamer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvStreamers = findViewById(R.id.rv_streamer)
        rvStreamers.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

    }

    private fun getListHeroes(): ArrayList<Streamer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_image)
        val listHero = ArrayList<Streamer>()
        for (i in dataName.indices) {
            val streamer = Streamer(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(streamer)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvStreamers.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListStreamerAdapter(list)
        rvStreamers.adapter = listHeroAdapter
    }


}