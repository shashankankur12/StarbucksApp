package com.example.starbucksapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.starbucksapp.viewModel.MainViewModel
import com.example.starbucksapp.R
import com.example.starbucksapp.adaptor.RestaurantAdaptor
import com.example.starbucksapp.adaptor.RestaurantListener
import com.example.starbucksapp.databinding.ActivityMainBinding
import com.example.starbucksapp.networking.model.StoreModel

class MainActivity : AppCompatActivity(), RestaurantListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.adapter = RestaurantAdaptor(listOf(), this)
        binding.lifecycleOwner = this
    }

    override fun onRestaurantClicked(restaurant: StoreModel) {
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra("data", restaurant)
        startActivity(intent)
    }
}