package uz.artikov.workmanagerpractice

import android.telecom.Call
import retrofit2.http.GET
import uz.artikov.workmanagerpractice.models.UserItem

interface ApiService {

    @GET("users")
    fun getUsers(): retrofit2.Call<List<UserItem>>

}