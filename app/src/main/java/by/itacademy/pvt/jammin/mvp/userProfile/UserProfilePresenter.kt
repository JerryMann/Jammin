package by.itacademy.pvt.jammin.mvp.userProfile

import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.entity.UserManagerTemp

class UserProfilePresenter {

    private var view: UserProfileView? = null

    fun setView(view: UserProfileView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun loadUserById(id: String) {
        val user: User? = UserManagerTemp.getUser(id)
        view?.showUser(user)
    }

    fun saveUserInYourList() {
        //TODO сохранение юзера в БД
    }
}