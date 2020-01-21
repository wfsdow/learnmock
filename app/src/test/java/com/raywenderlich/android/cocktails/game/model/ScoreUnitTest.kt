package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Test

class ScoreUnitTest {
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val score = Score( 0)

        score.increment()

        Assert.assertEquals("Current score should have been 1", 1, score.current)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val score = Score( 0)

        score.increment()

        Assert.assertEquals(1, score.highest)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        val score = Score(10)

        score.increment()

        Assert.assertEquals(10, score.highest)
    }
}