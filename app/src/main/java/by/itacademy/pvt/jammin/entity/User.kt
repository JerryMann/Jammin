package by.itacademy.pvt.jammin.entity

import com.google.gson.annotations.SerializedName

class User(

    @SerializedName("uid")
    val id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("instrument")
    var instrument: String?,

    @SerializedName("contact")
    var contact: String?,

    @SerializedName("imageUrl")
    var imageUrl: String
)