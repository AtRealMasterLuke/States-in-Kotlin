package com.example.captainhookgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captainhookgame.ui.theme.CaptainHookGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainHookGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
    @Composable
    fun CaptainGame() {
        val treasuresFound = remember {/*
        You can think remember as the captains log book that contains vital info
        e.g keeping track of the treasures collected*/
            mutableStateOf(0)
        }
        val direction = remember {
            mutableStateOf("North")/*
            The mutableState can be thought of as the steering wheel
            used to update the ship's direction*/
        }
        //Declare a new mutableStateOf variable named stormOrTreasure to hold a string value. Initialize it with an empty string
        val stormOrTreasure = remember {
            mutableStateOf("")
        }
        val health = remember {
            mutableStateOf(5)//player starts with 5 lives
        }
        //flag to check if the game is over
        val gameOver = remember {
            mutableStateOf(false)
        }
        Column {
            Text(text = "Treasures found: ${treasuresFound.value}")
            Text(text = "Current Direction: ${direction.value}")
            //Text composable to display the value of stormOrTreasure
            Text(text = stormOrTreasure.value)
            Text(text = "Health: ${health.value}")

            // If gameOver is true, show Game Over message
            if (gameOver.value){
                Text(text = "Game Over! You are out of lives!")
            }else{
                Button(onClick = {
                    sail("East", direction, treasuresFound, stormOrTreasure, health, gameOver)
                }) {
                    Text(text = "Sail East")
                }
                Button(onClick = {
                    sail("West", direction, treasuresFound, stormOrTreasure, health, gameOver)
                }) {
                    Text(text = "Sail West")
                }
                Button(onClick = {
                    sail("North", direction, treasuresFound, stormOrTreasure, health, gameOver)
                }) {
                    Text(text = "Sail North")
                }
                Button(onClick = {
                    sail("South", direction, treasuresFound, stormOrTreasure, health, gameOver)
                }) {
                    Text(text = "Sail South")
                }
            }

        }
    }
    /**
     * Function to handle sailing logic.
     */
    private fun sail(
        newDirection: String,
        direction: MutableState<String>,
        treasuresFound: MutableState<Int>,
        stormOrTreasure: MutableState<String>,
        health: MutableState<Int>,
        gameOver: MutableState<Boolean>
    ) {
        direction.value = newDirection
        if (Random.nextBoolean()) {
            treasuresFound.value += 1
            stormOrTreasure.value = "Found a Treasure!"
        } else {
            health.value -= 1 // Lose a life
            stormOrTreasure.value = "Storm Ahead! Lost 1 life."
            if (health.value <= 0) {
                gameOver.value = true // Trigger game over
                stormOrTreasure.value = "Storm Ahead! You lost your last life."
            }
        }
    }
}




