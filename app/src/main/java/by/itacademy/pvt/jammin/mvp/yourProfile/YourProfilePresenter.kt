package by.itacademy.pvt.jammin.mvp.yourProfile

import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.net.provideUserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class YourProfilePresenter {

    private val repository = provideUserRepository()
    private var disposable: Disposable? = null
    private var view: YourProfileView? = null
    private lateinit var user: User

    fun setView(view: YourProfileView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
        disposable?.dispose()
    }

    fun loadUser(id: String) {
        disposable = repository
            .getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                user = it
                view?.showProfile(it.imageUrl, it.name, it.instrument, it.contact)
            }, {
            })
    }

    fun saveChanges(id: String, name: String, instrument: String, contact: String, imageUrl: String) {
        disposable = repository
            .updateUser(
                User(
                    id = id,
                    name = name,
                    instrument = instrument,
                    contact = contact,
                    imageUrl = imageUrl
                    )
            ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{

            })
    }
}