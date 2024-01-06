package com.example.starbucksapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.starbucksapp.viewModel.MapViewModel
import com.example.starbucksapp.factory.MyViewModelFactory
import com.example.starbucksapp.R
import com.example.starbucksapp.databinding.ActivityMapBinding
import com.example.starbucksapp.networking.model.StoreModel

class MapActivity : AppCompatActivity() {
    lateinit var data: StoreModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMapBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_map)
        intent.extras?.let { bundle ->
            data = (bundle.getParcelable("data") as? StoreModel)!!
        }
        val viewModel = ViewModelProvider(this, MyViewModelFactory(data))[MapViewModel::class.java]

        binding.mapViewModel = viewModel
        binding.lifecycleOwner = this

    }
}