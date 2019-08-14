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
                "1",
                "123",
                "Richard",
            "saxophone",
            "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "1",
                "123",
                "Michael",
                "trumpet",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "1",
                "123",
                "Max",
                "trombone",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "1",
                "123",
                "Helen",
                "violin",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "1",
                "123",
                "Ann",
                "piano",
                "333-444-555",
                "1"
            ),User(
                Random(System.currentTimeMillis()).toString(),
                "1",
                "123",
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

    fun deleteUser(id: String) {
        userList.find { it.id == id }?.apply { userList.remove(this) }
    }

    fun updateUser(student: User) {
        val index = userList.indexOfFirst { it.id == student.id }
        if (index != -1) {
            userList[index] = student
        }
    }

    fun createUser(student: User) {
        userList.add(student)
    }

    fun findUser(query: String): List<User> {
        return userList.filter { it.name.contains(query, true) }
    }
}