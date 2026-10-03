package com.undyingguild.yahtzeegame.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.viewModelScope
import com.undyingguild.yahtzeegame.yahtzee.CategoryScore
import com.undyingguild.yahtzeegame.yahtzee.DiceRules
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds


class YahtzeeViewModel : ViewModel(){
    var diceValues by mutableStateOf(
        listOf( 3, 3, 3, 5, 5)
    )
        private set

    var categoryScores by mutableStateOf(
        emptyList<CategoryScore>()
    )
        private set

//    private val mainHandler = Handler(
//        Looper.getMainLooper()
//    )

    private fun rollDice(): Int{
        return Random.nextInt(1, 7)
    }

    fun rollOnce(){
        repeat(10){
            diceValues = List(5){
                rollDice()
            }
        }
        Thread.sleep(100)
    }

//    fun rollWithoutCoroutine() {
//
//        Thread {
//
//            repeat(10) {
//
//                val newValues = List(5) {
//                    rollDice()
//                }
//
//                mainHandler.post {
//
//                    diceValues = newValues
//                }
//
//                Thread.sleep(100)
//            }
//
//        }.start()
//    }
    fun rollWithCoroutine() {

        viewModelScope.launch {

            repeat(10) {

                diceValues = List(5) {
                    rollDice()
                }

                delay(100.milliseconds)
            }
            evaluateDice()
        }
    }
    private fun evaluateDice() {

        categoryScores =
            DiceRules
                .getAvailableCategories(diceValues)
                .map { category ->

                    CategoryScore(
                        category = category,
                        score = DiceRules.scoreFor(
                            category = category,
                            dice = diceValues
                        )
                    )
                }
    }
}