package com.undyingguild.yahtzeegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.undyingguild.yahtzeegame.ui.theme.YahtzeeGameTheme
import com.undyingguild.yahtzeegame.yahtzee.YahtzeeScreen
import androidx.activity.compose.setContent
import com.undyingguild.yahtzeegame.ui.YahtzeeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: YahtzeeViewModel = viewModel()

            YahtzeeScreen(
                viewModel = viewModel
            )

        }


    }
}
