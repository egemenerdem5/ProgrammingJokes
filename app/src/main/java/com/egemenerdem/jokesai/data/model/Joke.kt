package com.egemenerdem.jokesai.data.model

enum class JokeKind {
    SINGLE,
    TWO_PART
}

data class Joke(
    val id: Int,
    val category: String,
    val kind: JokeKind,
    val jokeText: String? = null,
    val setupText: String? = null,
    val deliveryText: String? = null
)
