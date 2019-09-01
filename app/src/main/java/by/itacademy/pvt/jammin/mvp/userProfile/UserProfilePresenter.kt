package by.itacademy.pvt.jammin.mvp.userProfile

import by.itacademy.pvt.jammin.net.provideUserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserProfilePresenter {

    private val repository = provideUserRepository()
    private var disposable: Disposable? = null
    private var view: UserProfileView? = null

    fun setView(view: UserProfileView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun loadUser(id: String) {
        disposable = repository
            .getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showUser(it)
            }, {
            })
    }

    fun saveUserInYourList() {
        //TODO сохранение юзера в БД
    }
}