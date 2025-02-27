package com.example.barmanapp.network

import retrofit2.Retrofit


class DrinksAPIService {
    private val BASE_URL =
        "www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita"

    private val retrofit = Retrofit.Builder()

    fun getCocktails() {
        retrofit.baseUrl(BASE_URL).build()
    }
}