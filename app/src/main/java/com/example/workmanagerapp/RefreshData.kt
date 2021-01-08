package com.example.workmanagerapp

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshData(val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val getData = inputData
        val myNumber = getData.getInt("intKey",0)
        refreshData(myNumber)
        return Result.success()
    }
    private fun refreshData(myNumber : Int) {
        val sharedPreferences = context.getSharedPreferences("com.example.workmanagerapp",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber = mySavedNumber+myNumber
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply()
    }
}