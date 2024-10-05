package com.example.ktor

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText


class MyHttpClient {
    private val client = HttpClient()
    suspend fun greeting(): List<User> {
        val response = client.get("https://api.github.com/users/1")
        return Gson().fromJson(response.bodyAsText(), object : TypeToken<List<User>>() {}.type)
    }
}