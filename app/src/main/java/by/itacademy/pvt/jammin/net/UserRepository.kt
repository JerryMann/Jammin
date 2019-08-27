package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun getUser(uid: String): Observable<User>

    fun updateUser(user: User): Completable
}