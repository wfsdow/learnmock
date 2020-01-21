package com.raywenderlich.android.cocktails.game.model

class Score(highScore: Int) {
    var current = 0
        private set

    var highest = highScore
        private set

    fun increment() {
        current ++
        if (current > highest)
            highest = current
    }
}