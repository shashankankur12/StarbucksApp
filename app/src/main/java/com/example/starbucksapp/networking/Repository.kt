package com.example.starbucksapp.networking

import com.example.starbucksapp.networking.model.ResponseModel
import com.google.gson.Gson

class Repository {
    suspend fun getRestaurantData(): ResponseModel {
        /*
        *Data Fetch from Json File
        */
        val rss = DataManager.readJSONFromAsset()

        /*
        *Data fetch from api Call
        */
//        val rss = DataManager.request()

        return Gson().fromJson(rss, ResponseModel::class.java)
    }
}