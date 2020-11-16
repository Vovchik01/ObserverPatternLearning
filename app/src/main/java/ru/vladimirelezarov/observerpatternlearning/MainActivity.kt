package ru.vladimirelezarov.observerpatternlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var votesCounter: VotesCounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        votesCounter = VotesCounter()
        votesCounter.addElector(GuyForTrump("John", "Sidorov"))
        votesCounter.addElector(GuyForTrump("Harry", "Potter"))
        votesCounter.addElector(GuyForTrump("Volk", "Tambovsky"))
        votesCounter.addElector(GuyForTrump("John", "Snow"))
        votesCounter.addElector(GuyForBiden("Pablo", "Escobar"))
        votesCounter.addElector(GuyForBiden("Alphonso", "Capone"))
        votesCounter.addElector(GuyForBiden("Neo", "Matrix"))
        votesCounter.addElector(GuyForBiden("Jesus", "Christ"))
        votesCounter.addElector(AverageElector("Ivan", "Ivanov"))
        votesCounter.addElector(AverageElector("Petr", "Petrov"))

        val simpleTV = findViewById<TextView>(R.id.simple_tv)
        simpleTV.setOnClickListener {
            votesCounter.updateVotes()
        }
    }
}