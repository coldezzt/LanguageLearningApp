package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {
    @GET("v2/entries/en/{theme}/")
    suspend fun getDifinitions(@Path("theme") theme: String) : DefinitionsResponse
}