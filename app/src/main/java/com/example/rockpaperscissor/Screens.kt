package com.example.rockpaperscissor

sealed class Screens(val route:String) {
    object UIScreen:Screens("ui")
    object MainScreen:Screens("main")
}
