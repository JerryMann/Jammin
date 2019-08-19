package by.itacademy.pvt.jammin.mvp.userProfile

import by.itacademy.pvt.jammin.entity.User

interface UserProfileView {
    fun showUser(user: User?)
}