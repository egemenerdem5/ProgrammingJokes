package com.egemenerdem.jokesai.data.repository

import com.egemenerdem.jokesai.data.api.JokeApiService
import com.egemenerdem.jokesai.data.api.RetrofitClient
import com.egemenerdem.jokesai.data.model.Joke
import com.egemenerdem.jokesai.data.model.JokeDto
import com.egemenerdem.jokesai.data.model.JokeKind

class JokeRepository(
    private val apiService: JokeApiService = RetrofitClient.jokeApiService
) {
    suspend fun fetchProgrammingJokes(amount: Int = 10): Result<List<Joke>> {
        return runCatching {
            val response = apiService.getProgrammingJokes(amount = amount)
            if (response.error) {
                throw Exception("Failed to fetch jokes from JokeAPI")
            }
            val dtoList = response.jokes ?: emptyList()
            dtoList.mapNotNull { it.toDomainJoke() }
        }
    }

    private fun JokeDto.toDomainJoke(): Joke? {
        val categoryName = category ?: "Programming"
        return when (type) {
            "single" -> {
                val text = joke ?: return null
                Joke(
                    id = id,
                    category = categoryName,
                    kind = JokeKind.SINGLE,
                    jokeText = text
                )
            }
            "twopart" -> {
                val setup = setup ?: return null
                val delivery = delivery ?: return null
                Joke(
                    id = id,
                    category = categoryName,
                    kind = JokeKind.TWO_PART,
                    setupText = setup,
                    deliveryText = delivery
                )
            }
            else -> null
        }
    }
}
