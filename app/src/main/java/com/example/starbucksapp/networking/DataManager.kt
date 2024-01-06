package com.example.starbucksapp.networking

import com.example.starbucksapp.base.MyApplication
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class DataManager {
    companion object {
        suspend fun request(): String {
            return suspendCancellableCoroutine { continuation ->
                try {
                    val reader: BufferedReader
                    val url = URL("https://reqres.in/api/users?page=" + 1 + "&per_page=6")
                    with(url.openConnection() as HttpURLConnection) {
                        requestMethod = "GET"
                        connectTimeout = 10000
                        readTimeout = 10000

                        reader = BufferedReader(InputStreamReader(inputStream) as Reader?)
                        val response = StringBuffer()
                        var inputLine = reader.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = reader.readLine()
                        }
                        reader.close()

                        if (continuation.isActive) {
                            continuation.resume(response.toString())
                        }
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                    if (continuation.isActive) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        }

        fun readJSONFromAsset(): String? {
            var json: String? = null
            try {
                val inputStream: InputStream? =
                    MyApplication.application?.assets?.open("response.json")
                json = inputStream?.bufferedReader().use { it?.readText() }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}
