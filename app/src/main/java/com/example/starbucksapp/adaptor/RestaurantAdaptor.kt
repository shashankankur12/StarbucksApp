package com.example.starbucksapp.adaptor

import com.example.starbucksapp.R
import com.example.starbucksapp.base.BaseAdapter
import com.example.starbucksapp.databinding.ItemRestaurantBinding
import com.example.starbucksapp.networking.model.StoreModel


class RestaurantAdaptor(list: List<StoreModel>, private val restaurantListener: RestaurantListener) : BaseAdapter<ItemRestaurantBinding, StoreModel>(list){

    override val layoutId: Int = R.layout.item_restaurant

    override fun bind(binding: ItemRestaurantBinding, item: StoreModel) {
        binding.apply {
            restaurant = item
            listener = restaurantListener
            executePendingBindings()
        }
    }
}

interface RestaurantListener {
    fun onRestaurantClicked(movie: StoreModel)
}