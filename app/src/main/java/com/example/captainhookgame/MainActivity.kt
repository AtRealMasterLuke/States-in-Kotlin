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
        Column {
            Text(text = "Treasures found: ${treasuresFound.value}")
            Text(text = "Current Direction: ${direction.value}")
            Button(onClick = {
                direction.value = "East" /*Change the direction upon clicking Sail East btn*/
                /*Depending on some luck factors, we may run into a storm or treasures*/
                if (Random.nextBoolean()) {//This is a 50/50 chance randomizer
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                direction.value = "West" /*Change the direction upon clicking Sail West btn*/
                /*Depending on some luck factors, we may run into a storm or treasures*/
                if (Random.nextBoolean()) {//This is a 50/50 chance randomizer
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail West")
            }
            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail North")
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail South")
            }
        }
    }
}



