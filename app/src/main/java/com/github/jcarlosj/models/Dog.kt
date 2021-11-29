package com.github.jcarlosj.models

import com.google.gson.annotations.SerializedName

data class Dog(
    /** SerializedName contendrá los nombres de las propiedades de la API (status, message), sus equivalentes dentro de la aplicación serán los que se encuentran fuera (status, urlImages ) */
    private @SerializedName( "status" ) val status: String,
    private @SerializedName( "message" ) val urlImages: List<String>
)
