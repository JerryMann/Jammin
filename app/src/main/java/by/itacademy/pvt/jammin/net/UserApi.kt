package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface UserApi {

    @GET("data/Users/{id}")
    fun getUser(
        @Path("id") id: String
    ): Single<User>

    @PUT("data/Users/{uid}")
    fun updateUser(
        @Path("uid") uid: String,
        @Body User: User
    ): Completable

    @GET("data/Users")
    fun getUserByInstrument(
        @Query("where") condition: String
    ): Observable<MutableList<User>>
}