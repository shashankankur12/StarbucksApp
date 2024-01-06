package com.example.starbucksapp.networking.model

import android.os.Parcel
import android.os.Parcelable
import com.example.starbucksapp.base.ListAdapterItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreModel() : ListAdapterItem, Parcelable {
    @SerializedName("id")
    @Expose
    override var id: Long = 0

    @SerializedName("distance")
    @Expose
    var distance: Float = 0F

    @SerializedName("addressLines")
    @Expose
    var addressLines: ArrayList<String>? = null

    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        distance = parcel.readFloat()
        addressLines = parcel.createStringArrayList()
        coordinates = parcel.readValue(Coordinates::class.java.classLoader) as Coordinates
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getCompleteAddress(): String {
        return addressLines?.joinToString(separator = ",") ?: "NA"
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeLong(id)
        parcel.writeFloat(distance)
        parcel.writeStringList(addressLines)
        parcel.writeValue(coordinates)
    }

    companion object CREATOR : Parcelable.Creator<StoreModel> {
        override fun createFromParcel(parcel: Parcel): StoreModel {
            return StoreModel(parcel)
        }

        override fun newArray(size: Int): Array<StoreModel?> {
            return arrayOfNulls(size)
        }
    }
}