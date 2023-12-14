

package com.example.android_project.ApiCalls

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import okhttp3.Headers

class ApiCalls {

    // Headers por defecto de la api
    private val defaultHeaders: ArrayList<Pair<String, String>> = arrayListOf(
        "Authorization" to "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTllYjlkNzk1YmZiYjMwY2FhODRjYTMxNmFiODk2YyIsInN1YiI6IjY1NmUwMWIxNGE0YmY2MDEyMDI4ZGUyNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UrQqa_FuEXJL8zkvPtu2OcNb47MxY3Nn55R6nYyP92M",
        "Content-Type" to "application/json"
    )

    // Función para realizar una llamada GET a una API
    fun fetchDataFromApi(apiUrl: String, onComplete: (String) -> Unit) {
        // Launch a coroutine on the IO dispatcher
        GlobalScope.launch(Dispatchers.IO) {
            try {
                // Gestionar conexión HTTP
                val client = OkHttpClient()

                // Crear objeto Headers y añadir los encabezados por defecto
                val headersBuilder = Headers.Builder()
                for ((name, value) in defaultHeaders) {
                    headersBuilder.add(name, value)
                }
                val requestHeaders = headersBuilder.build()

                // Hacer un objeto request utilizando Request.Builder() y especificando la URL
                val request = Request.Builder()
                    .url(apiUrl)
                    .headers(requestHeaders) // Añadir headers
                    .build()

                // Hacemos la petición y obtenemos la respuesta
                val response: okhttp3.Response = client.newCall(request).execute()

                // Transformamos el objeto de tipo Response a un String
                val responseData = response.body?.string() ?: ""

                // Llamamos a la función onComplete con la respuesta
                onComplete(responseData)
            } catch (e: IOException) {
                e.printStackTrace()
                // Llamamos a la función onComplete con una cadena vacía en caso de error
                onComplete("")
            }
        }
    }
}
