package by.itacademy.pvt.jammin.net

fun provideUserRepository(): UserRepository {
    return UserRepositoryRemote(
        NetProvider.provideUserApi(
            NetProvider.provideRetrofit(
                "https://jammin-569fb/",
                NetProvider.provideOhHttp(),
                NetProvider.provideGson()
            )
        )
    )
}