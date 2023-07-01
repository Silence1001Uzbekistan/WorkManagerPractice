package uz.artikov.workmanagerpractice

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import retrofit2.Call
import retrofit2.Response
import uz.artikov.workmanagerpractice.models.UserItem
import javax.security.auth.callback.Callback

class UploadWork(context: Context, workerParameteres: WorkerParameters) :
    Worker(context, workerParameteres) {

    private val TAG = "UploadWork"

    override fun doWork(): Result {

        getUsers()

        return Result.success()

    }

    private fun getUsers() {

        ApiClient.getRetrofit().create(ApiService::class.java).getUsers()
            .enqueue(object : retrofit2.Callback<List<UserItem>> {
                override fun onResponse(
                    call: Call<List<UserItem>>,
                    response: Response<List<UserItem>>
                ) {

                    if (response.isSuccessful) {

                        val body = response.body()

                        body?.forEach {
                            Log.d(TAG, "onResponse: $it")

                        }

                    }

                }

                override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {


                }

            })

    }


}