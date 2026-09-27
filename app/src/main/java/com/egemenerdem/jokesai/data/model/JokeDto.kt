package com.egemenerdem.jokesai.data.model

import com.google.gson.annotations.SerializedName

data class JokeDto(
    @SerializedName("id") val id: Int,
    @SerializedName("category") val category: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("joke") val joke: String?,
    @SerializedName("setup") val setup: String?,
    @SerializedName("delivery") val delivery: String?,
    @SerializedName("safe") val safe: Boolean?
)
