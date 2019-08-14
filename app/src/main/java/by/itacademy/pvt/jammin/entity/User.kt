package by.itacademy.pvt.jammin.entity

class User(
    val id: String,
    var email: String,
    var password: String,
    var name: String,
    var instrument: String?,
    var contact: String?,
    var imageUrl: String?
)