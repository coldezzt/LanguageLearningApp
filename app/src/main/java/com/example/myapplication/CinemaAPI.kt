package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Path

interface CinemaAPI {

    @GET("movies/{page}")
    suspend fun getMovies(@Path("page") page: Int) : MoviesResponse
}