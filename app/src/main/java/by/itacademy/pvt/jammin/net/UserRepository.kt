package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface UserRepository {

    fun getUser(id: String): Single<User>

    fun updateUser(user: User): Completable

    fun getUserByInstrument(instrument: String): Observable<MutableList<User>>
}