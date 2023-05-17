package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeaningAdapter: RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {

    val definitions = mutableListOf<Definition>()

    class MeaningViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.meaningText)

        fun onBind(text: String) {
            textView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meaning, parent, false)
        return MeaningViewHolder(view)
    }

    override fun getItemCount(): Int = definitions.size

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.onBind(definitions[position].definition)
    }
}