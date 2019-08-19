package by.itacademy.pvt.jammin.entity


import kotlin.random.Random

object UserManagerTemp {

    private var userList: MutableList<User> = mutableListOf()

    fun getUserList(): MutableList<User> {
        if (userList.isEmpty()) {
            createStudentList()
        }
        return userList
    }

    private fun createStudentList(): MutableList<User> {
        userList = mutableListOf(
            User(
                Random(System.currentTimeMillis()).toString(),
                "Richard",
            "saxophone",
            "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "Michael",
                "trumpet",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "Max",
                "trombone",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "Helen",
                "violin",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "Ann",
                "piano",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "Kate",
                "saxophone",
                "333-444-555",
                "1"
            )
        )
        return userList
    }

    fun getUser(id: String): User? {
        return userList.find { it.id == id }
    }

    fun findUser(query: String): List<User> {
        return userList.filter { it.instrument!!.contains(query, true) }
    }
}