package uk.ac.tees.w9601166.careercatalyst.data

import kotlin.random.Random

private val fruits = mutableListOf(
    listOf("Apple", "Banana", "Orange"),
    listOf("Mango", "Papaya", "Peach"),
    listOf("Coconut", "Passion", "Pawpaw"),
    listOf("Banana", "Papaya", "Pawpaw"),
    listOf("Orange", "Mango", "Coconut"),
)

fun createUserData(userName: String) : UserData {
    return UserData(
        userName,
        getRandomAge(),
        getRandomFruits()
    )
}

private fun getRandomAge(): Int {
    return Random.nextInt(7, 70)
}

private fun getRandomFruits(): List<String> {

    val randomIndex = Random.nextInt(fruits.size)
    return fruits[randomIndex]
}