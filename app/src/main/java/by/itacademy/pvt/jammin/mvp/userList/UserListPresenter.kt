package by.itacademy.pvt.jammin.mvp.userList

import android.content.Context

class UserListPresenter {

    private var view: UserListView? = null
    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun setView(view: UserListView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun loadSavedList() {
        //TODO показать сохраненных юзеров из БД
    }
}