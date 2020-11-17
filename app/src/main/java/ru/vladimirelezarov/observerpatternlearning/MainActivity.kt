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
        votesCounter.apply {
            addElector(GuyForTrump("John", "Sidorov"))
            addElector(GuyForTrump("Harry", "Potter"))
            addElector(GuyForTrump("Volk", "Tambovsky"))
            addElector(GuyForTrump("John", "Snow"))
            addElector(GuyForBiden("Pablo", "Escobar"))
            addElector(GuyForBiden("Alphonso", "Capone"))
            addElector(GuyForBiden("Neo", "Matrix"))
            addElector(GuyForBiden("Jesus", "Christ"))
            addElector(AverageElector("Ivan", "Ivanov"))
            addElector(AverageElector("Petr", "Petrov"))
        }

        val simpleTV = findViewById<TextView>(R.id.simple_tv)
        simpleTV.setOnClickListener {
            votesCounter.updateVotes()
        }
    }
}