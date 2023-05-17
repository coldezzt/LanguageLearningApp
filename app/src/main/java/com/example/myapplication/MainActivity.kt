package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MeaningAPI::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.meaningsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MeaningAdapter()
        recyclerView.adapter = adapter

        GlobalScope.launch(Dispatchers.IO) {
            val response = service.getDefinitions("cooking")
            Log.d("MainActivity", response.toString())
            withContext(Dispatchers.Main) {
                adapter.definitions.addAll(response)
                adapter.notifyDataSetChanged()
            }
        }
    }
}