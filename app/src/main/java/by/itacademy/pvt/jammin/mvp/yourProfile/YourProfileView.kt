package by.itacademy.pvt.jammin.mvp.yourProfile

import by.itacademy.pvt.jammin.entity.User

interface YourProfileView {
    fun showProfile(imageUrl: String?, name: String, instrument: String, contact: String)
}