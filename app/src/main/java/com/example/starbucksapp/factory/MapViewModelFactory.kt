package com.example.starbucksapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starbucksapp.networking.model.StoreModel
import com.example.starbucksapp.viewModel.MapViewModel

class MyViewModelFactory constructor(private val model: StoreModel): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MapViewModel::class.java!!)) {
            MapViewModel(model) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}