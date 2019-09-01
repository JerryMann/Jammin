package by.itacademy.pvt.jammin.entity

import com.google.gson.annotations.SerializedName

class User(

    @SerializedName("objectId")
    val id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("instrument")
    var instrument: String,

    @SerializedName("contact")
    var contact: String,

    @SerializedName("imgUrl")
    var imageUrl: String?
)