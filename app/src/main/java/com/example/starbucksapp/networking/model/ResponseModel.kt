package com.example.starbucksapp.networking.model

data class ResponseModel(val page: Int, val per_page: Int, val total: Int, val stores:List<StoreModel>)