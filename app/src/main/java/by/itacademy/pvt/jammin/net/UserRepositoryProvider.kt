package by.itacademy.pvt.jammin.net

fun provideUserRepository(): UserRepository {
    return UserRepositoryRemote(
        NetProvider.provideUserApi(
            NetProvider.provideRetrofit(
                "https://jammin-569fb.firebaseio.com/",
                NetProvider.provideOhHttp(),
                NetProvider.provideGson()
            )
        )
    )
}