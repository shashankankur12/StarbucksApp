package com.example.starbucksapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucksapp.networking.Repository
import com.example.starbucksapp.networking.model.StoreModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel(){
    var resultList: MutableLiveData<List<StoreModel>> = MutableLiveData()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val rss = Repository().getRestaurantData()
            withContext(Dispatchers.Main) {
                resultList.value= rss.stores
            }
        }
    }

}