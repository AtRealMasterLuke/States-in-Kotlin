# States-in-Kotlin

## Captain Hook Game
Captain Hook Game is a simple Android app built using Jetpack Compose to help you understand and practice working with states in Kotlin. The game allows you to sail in different directions, find treasures, and encounter storms, making it an engaging way to learn state management concepts in a fun context.

## Features

- Navigate the ship in four directions: North, East, South, and West.
- Find treasures or encounter storms randomly while sailing.
- Track the number of treasures found.
- Manage your health (starting with 5 lives) — lose a life each time you encounter a storm.
- Game Over condition when health reaches zero.

## Learning Objectives

This project was created for educational purposes, with the following goals:

- Learn about **state management** in Jetpack Compose.
- Understand how to use `remember` and `mutableStateOf` to manage state in a composable.
- Explore how state changes dynamically update the UI.
- Practice using Kotlin concepts like functions, conditional statements, and randomization.

## How It Works

1. The app starts with the player having 5 lives and 0 treasures found.
2. The player can choose a direction to sail by pressing the corresponding button.
3. Each time the player sails, they either find a treasure (increasing the treasure count) or encounter a storm (losing a life).
4. The game ends when the player's health reaches zero, displaying a Game Over message.

## Key Concepts Used

- **Jetpack Compose**: Modern Android UI toolkit.
- **State Management**: Using `remember` and `mutableStateOf` to track and update values like treasures found, health, and direction.
- **Randomization**: Simulating the randomness of treasures and storms with `Random.nextBoolean()`.
- **Composable Functions**: Breaking down the UI into reusable components.

## Code Highlights

Here are some key snippets:

### Managing State

```kotlin
val treasuresFound = remember { mutableStateOf(0) }
val health = remember { mutableStateOf(5) }
val direction = remember { mutableStateOf("North") }
val stormOrTreasure = remember { mutableStateOf("") }
```

### Handling Sailing Logic

```kotlin
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
        health.value -= 1
        stormOrTreasure.value = "Storm Ahead! Lost 1 life."
        if (health.value <= 0) {
            gameOver.value = true
            stormOrTreasure.value = "Storm Ahead! You lost your last life."
        }
    }
}
```


## Dependencies

- Android Studio Bumblebee or newer.
- Jetpack Compose version 1.5.1 or higher.
- Kotlin 1.8.0 or higher.

## Future Improvements

- Add animations to make the game more engaging.
- Introduce new obstacles and power-ups.
- Create a leaderboard to track high scores.
