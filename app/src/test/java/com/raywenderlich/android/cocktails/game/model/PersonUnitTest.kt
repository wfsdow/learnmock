package com.raywenderlich.android.cocktails.game.model

import org.junit.Test

class PersonUnitTest {
    @Test
    fun testPersonNameAccess() {
        val person = Person("maybe", 18)
        person.name = "somebody"
    }
}