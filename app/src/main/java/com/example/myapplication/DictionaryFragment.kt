package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class DictionaryFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MeaningAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = service.getDefinitions("cooking")[0]
            withContext(coroutineContext) {
                val recyclerView = view.findViewById<RecyclerView>(R.id.meaningsRecyclerView)
                recyclerView.layoutManager = LinearLayoutManager(context)
                val adapter = MeaningAdapter(response)
                recyclerView.adapter = adapter
                with(view) {
                    findViewById<TextView>(R.id.wordSearched).text = response.word.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    }
                    findViewById<TextView>(R.id.wordTranscription).text = response.phonetic
                    findViewById<TextView>(R.id.wordPartOfSpeech).text = response.meanings[0].partOfSpeech
                }
            }
        }

        var searchButton = view.findViewById<Button>(R.id.searchIcon)
        searchButton.setOnClickListener {
            
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }
}