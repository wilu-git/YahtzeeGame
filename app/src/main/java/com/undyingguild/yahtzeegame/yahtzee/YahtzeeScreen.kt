package com.undyingguild.yahtzeegame.yahtzee

import android.R.attr.onClick
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.undyingguild.yahtzeegame.R
import com.undyingguild.yahtzeegame.ui.YahtzeeViewModel

@Composable
fun YahtzeeScreen(
    viewModel: YahtzeeViewModel
){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Yahtzee"
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)){
            viewModel.diceValues.forEach { value ->
                Die (
                    value = value
                )
            }
        }
        Button (
            onClick = {
//                viewModel.rollOnce()
//                viewModel.rollWithoutCoroutine()
                viewModel.rollWithCoroutine()
            }
        ){
            Text("Roll")
        }

        viewModel.categoryScores.forEach {results ->
            Text(
                text = "${results.category}: ${results.score}"
            )
        }
    }
}

@Composable
fun Die(value: Int){
    val diceImage = when(value){
        1 -> R.drawable.die_1
        2 -> R.drawable.die_2
        3 -> R.drawable.die_3
        4 -> R.drawable.die_4
        5 -> R.drawable.die_5
        6 -> R.drawable.die_6

        else -> R.drawable.die_1
    }
    Image (
        painter = painterResource(
            id = diceImage
        ),
        contentDescription = "Dice showing $value",
        modifier = Modifier.size(70.dp)
    )
}
