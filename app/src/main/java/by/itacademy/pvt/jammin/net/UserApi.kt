package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.*

interface UserApi {

    @GET("Users/{uid}.json")
    fun getUser(
        @Path("uid") uid: String
    ): Observable<User>

    @PUT("Users/{uid}.json")
    fun updateUser(
        @Path("uid") uid: String,
        @Body User: User
    ): Completable
}