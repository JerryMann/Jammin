package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Single

interface UserRepository {

    fun getUser(uid: String): Single<User>
}