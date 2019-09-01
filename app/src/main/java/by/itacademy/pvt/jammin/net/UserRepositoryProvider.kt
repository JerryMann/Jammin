package by.itacademy.pvt.jammin.net

fun provideUserRepository(): UserRepository {
    return UserRepositoryRemote(
        NetProvider.provideUserApi(
            NetProvider.provideRetrofit(
                "https://api.backendless.com/3DB46DD2-BE7E-A51D-FF8E-21FAF7837500/D9AE0932-3492-17DB-FF46-C93DAE09D500/",
                NetProvider.provideOhHttp(),
                NetProvider.provideGson()
            )
        )
    )
}