package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Path

interface MeaningAPI {
    @GET("en/{theme}")
    suspend fun getDefinitions(@Path("theme") theme: String) : Word
}