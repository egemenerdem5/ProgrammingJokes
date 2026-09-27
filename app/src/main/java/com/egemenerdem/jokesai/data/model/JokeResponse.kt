package com.egemenerdem.jokesai.data.model

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("amount") val amount: Int?,
    @SerializedName("jokes") val jokes: List<JokeDto>?
)
