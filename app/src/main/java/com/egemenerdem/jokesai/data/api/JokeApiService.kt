package com.egemenerdem.jokesai.data.api

import com.egemenerdem.jokesai.data.model.JokeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeApiService {
    @GET("joke/Programming")
    suspend fun getProgrammingJokes(
        @Query("amount") amount: Int = 10
    ): JokeResponse
}
