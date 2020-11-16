package ru.vladimirelezarov.observerpatternlearning

import android.util.Log

/**
 * Guys who are getting notification every time when Trump gets more votes
 **/
class GuyForTrump(private val name: String, private val surname: String) : FanBehavior {
    override fun toBeInTouch(votesForTrump: Int, votesForBiden: Int) {
        Log.i("GuyForTrump", "Trump $votesForTrump - Biden $votesForBiden")
        toDoAHappyDance()
    }

    override fun toDoAHappyDance() {
        Log.i("GuyForTrump", "$name $surname :Aaaaaaw yeeeeee!!!")
    }
}

/**
 * Guys who are getting notification every time when Biden gets more votes
 **/
class GuyForBiden(private val name: String, private val surname: String) : FanBehavior {
    override fun toBeInTouch(votesForTrump: Int, votesForBiden: Int) {
        Log.i("GuyForBiden", "Biden $votesForBiden - Trump $votesForTrump")
        toDoAHappyDance()
    }

    override fun toDoAHappyDance() {
        Log.i("GuyForBiden", "$name $surname Yeeeeee Aaaaaaw!!!")
    }
}

/**
 * Guys who are getting notification every time when votes are updates
 **/
class AverageElector(private val name: String, private val surname: String) : AverageElectorBehavior {
    override fun toBeInTouch(votesForTrump: Int, votesForBiden: Int) {
        Log.i("GuyForEverybody", "Biden $votesForBiden - Trump $votesForTrump")
        reactionToNotification()
    }

    override fun reactionToNotification() {
        Log.i("GuyForEverybody", "$name $surname : Ok.")
    }
}

interface AverageElectorBehavior : ElectorsBehavior {
    fun reactionToNotification()
}

interface FanBehavior : ElectorsBehavior {
    fun toDoAHappyDance()
}

interface ElectorsBehavior {
    fun toBeInTouch(votesForTrump: Int, votesForBiden: Int)
}