package by.itacademy.pvt.jammin.mvp.userList

import by.itacademy.pvt.jammin.entity.User

interface UserListView {
    fun showList(list: List<User>)
}