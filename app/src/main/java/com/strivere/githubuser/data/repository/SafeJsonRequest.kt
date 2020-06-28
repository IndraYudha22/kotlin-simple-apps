package com.strivere.githubuser.data.repository

import android.content.Context
import android.util.Log
import java.io.IOException

open class SafeJsonRequest {
    open fun readJsonData(context: Context): String? {
        val json: String
        try {
            val inputStream = context.assets.open("githubuser.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        // print the data
        Log.i("data", json)
        return json
    }
}