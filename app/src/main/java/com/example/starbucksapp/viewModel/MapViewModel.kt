package com.example.starbucksapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starbucksapp.networking.model.StoreModel
import com.google.android.gms.maps.model.LatLng

class MapViewModel(model: StoreModel): ViewModel() {
    val latlong : MutableLiveData<LatLng> =MutableLiveData()
    val place : MutableLiveData<String> = MutableLiveData()

    init {
        latlong.value= LatLng(model.coordinates!!.latitude, model.coordinates!!.longitude)
        place.value= model.getCompleteAddress()
    }
}