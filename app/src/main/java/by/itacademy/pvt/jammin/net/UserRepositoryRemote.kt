package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable

class UserRepositoryRemote(private val api: UserApi) : UserRepository {
    override fun updateUser(user: User): Completable {
        return api.updateUser(user.id, user)
    }

    override fun getUser(uid: String): Observable<User> {
        return api.getUser(uid)
    }
}