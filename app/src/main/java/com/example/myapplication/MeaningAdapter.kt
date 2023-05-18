package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeaningAdapter(private val word: Word): RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {

    private val definitions = word.meanings[0].definitions

    class MeaningViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.meaningText)

        fun onBind(text: String) {
            textView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder =
        MeaningViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meaning, parent, false))

    override fun getItemCount(): Int = definitions.size

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.definition).text = definitions[position].definition
            findViewById<TextView>(R.id.definition_example).text = definitions[position].example
        }
    }
}