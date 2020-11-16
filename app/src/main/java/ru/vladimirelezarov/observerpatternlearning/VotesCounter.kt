package ru.vladimirelezarov.observerpatternlearning

import java.util.*

const val MAX_VOTES = 538

class VotesCounter {
    private val electors: MutableList<ElectorsBehavior> = mutableListOf()

    var votesForTrump = 0
    var votesForBiden = 0

    fun addElector(elector: ElectorsBehavior) {
        electors.add(elector)
    }

    fun removeElector(elector: ElectorsBehavior) {
        electors.remove(elector)
    }

    fun updateVotes() {
        votesForTrump = Random().nextInt(MAX_VOTES)
        votesForBiden = MAX_VOTES - votesForTrump
        sendNotification()
    }

    private fun sendNotification() {
        electors.forEach {
            when {
                votesForTrump > votesForBiden && it is GuyForTrump -> it.toBeInTouch(
                    votesForTrump,
                    votesForBiden
                )
                votesForBiden > votesForTrump && it is GuyForBiden -> it.toBeInTouch(
                    votesForTrump,
                    votesForBiden
                )
                it is AverageElector -> it.toBeInTouch(votesForTrump, votesForBiden)
            }
        }
    }
}