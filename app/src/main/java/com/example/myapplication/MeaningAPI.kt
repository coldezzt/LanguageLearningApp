package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Path

interface MeaningAPI {
    @GET("v2/entries/en/{theme}")
    suspend fun getDefinitions(@Path("theme") theme: String) : List<MeaningResponse>
}