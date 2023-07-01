package uz.artikov.workmanagerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import uz.artikov.workmanagerpractice.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.OneStartButtonId.setOnClickListener {

            val workRequest: WorkRequest =
                OneTimeWorkRequestBuilder<UploadWork>().setInitialDelay(2, TimeUnit.MINUTES).build()

            WorkManager.getInstance(this).enqueue(workRequest)

        }

        binding.ReplayStartButtonId.setOnClickListener {

            val workRequest = PeriodicWorkRequestBuilder<UploadWork>(1, TimeUnit.MINUTES).build()
            WorkManager.getInstance(this).enqueue(workRequest)

        }

        binding.StopButtonId.setOnClickListener {


        }

    }
}