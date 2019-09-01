package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class UserRepositoryRemote(private val api: UserApi) : UserRepository {

    override fun getUserByInstrument(instrument: String): Observable<MutableList<User>> {
        return api.getUserByInstrument("instrument LIKE '%$instrument%'")
    }

    override fun updateUser(user: User): Completable {
        return api.updateUser(user.id, user)
    }

    override fun getUser(id: String): Single<User> {
        return api.getUser(id)
    }
}