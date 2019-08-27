package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Single

class UserRepositoryRemote(private val api: UserApi) : UserRepository {

    override fun getUser(uid: String): Single<User> {
        return api.getUser(uid)
    }
}