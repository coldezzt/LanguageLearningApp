package com.example.myapplication

data class Word(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
)
