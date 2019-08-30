package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface UserRepository {

    fun getUser(uid: String): Observable<User>

    fun getAllUsers(): Single<List<User>>

    fun updateUser(user: User): Completable

    fun getUserByInstrument(instrument: String): Observable<List<User>>
}