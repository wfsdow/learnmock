package com.raywenderlich.android.cocktails.game.common.repository

import android.content.SharedPreferences
import com.nhaarman.mockitokotlin2.*
import com.raywenderlich.android.cocktails.common.network.CocktailsApi
import com.raywenderlich.android.cocktails.common.repository.CocktailsRepositoryImpl
import org.junit.Before
import org.junit.Test

class RepositoryUintTest {
    private lateinit var  api: CocktailsApi
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sp :SharedPreferences
    private lateinit var repository :CocktailsRepositoryImpl

    @Before
    fun setup() {
        api = mock()
        sp = mock()
        editor = mock()
        whenever(sp.edit()).thenReturn(editor)
        repository = CocktailsRepositoryImpl(api, sp)
    }

    @Test
    fun saveScore_shouldSaveToSP() {
        val score = 100
        repository.saveHighScore(score)
        inOrder(editor) {
            verify(editor).putInt(any(), eq(score))
            verify(editor).commit()
        }
    }

    @Test
    fun getScore_shouldGetFromSharedPreferences() {
        repository.getHighScore()
        verify(sp).getInt(any(), any())
    }
}