package by.itacademy.pvt.jammin.net

import by.itacademy.pvt.jammin.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
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

    @GET("Users/.json")
    fun getAllUsers(): Single<List<User>>

    @GET("Users/.json")
    fun getUserByInstrument(
        @Query("instrument") instrument: String
    ): Observable<List<User>>
}