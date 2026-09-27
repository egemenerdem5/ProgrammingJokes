package com.egemenerdem.jokesai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.egemenerdem.jokesai.ui.screens.JokesScreen
import com.egemenerdem.jokesai.ui.theme.JokesAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokesAITheme {
                JokesScreen()
            }
        }
    }
}
