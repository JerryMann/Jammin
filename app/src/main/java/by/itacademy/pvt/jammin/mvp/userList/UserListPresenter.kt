package by.itacademy.pvt.jammin.mvp.userList

import android.content.Context
import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.net.provideUserRepository
import by.itacademy.pvt.jammin.utils.RecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserListPresenter {

    private val repository = provideUserRepository()
    private var listUsers: MutableList<User> = mutableListOf()
    private var disposable: Disposable? = null
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

    fun getUsersByInstrument(instrument: String, adapter: RecyclerAdapter) {
        view?.progressBarOn()
        disposable = repository.getUserByInstrument(instrument)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listUsers.clear()
                listUsers.addAll(it)
                adapter.updateList(listUsers)
                view?.progressBarOff()
            }, {
                view?.progressBarOff()
            })
    }

    fun loadSavedList() {
        //TODO показать сохраненных юзеров из БД
    }
}