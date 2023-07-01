package uz.artikov.workmanagerpractice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun getRetrofit(): Retrofit {

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
            BASE_URL
        ).build()

    }

}