package com.example.workmanagerapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data.Builder().putInt("intKey",1).build()
        val constraints = Constraints.Builder()
            //.setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(false)
            .build()

        //OneTimeWorkRequestBuilder
       /* val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshData>()
            .setConstraints(constraints)
            .setInputData(data)
            //.setInitialDelay(5, TimeUnit.MILLISECONDS)
            //.addTag("myTag")
            .build()
          WorkManager.getInstance(this).enqueue(myWorkRequest)
        */

        //PeriodicRequestBuilder
        val myWorkRequest : PeriodicWorkRequest = PeriodicWorkRequestBuilder<RefreshData>(15,TimeUnit.MINUTES)
                .setConstraints(constraints)
                .setInputData(data)
                .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id).observe(this, Observer {
            if(it.state == WorkInfo.State.RUNNING){
                println("Running")
            }
            else if(it.state == WorkInfo.State.FAILED){
                println("Failed")
            }
            else if(it.state == WorkInfo.State.SUCCEEDED){
                println("Succeeded")
            }
        })

        //WorkManager.getInstance(this).cancelAllWork()

        // -- Chaning
 /*
        val oneTimeRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefreshData>()
                .setConstraints(constraints)
                .setInputData(data)
                .build()
        WorkManager.getInstance(this).beginWith(oneTimeRequest)
                .then(oneTimeRequest)
                .then(oneTimeRequest)
                .enqueue()

  */
    }
}