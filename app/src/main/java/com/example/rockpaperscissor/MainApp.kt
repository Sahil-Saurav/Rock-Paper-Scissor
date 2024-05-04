package com.example.rockpaperscissor

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainApp(){
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = Screens.MainScreen.route) {
        composable(route=Screens.MainScreen.route){
            MainScreen(){name,rounds->
                navcontroller.navigate(route=Screens.UIScreen.route+"/$name/$rounds")
            }
        }
        composable(route=Screens.UIScreen.route+"/{name}/{rounds}"){
            val name = it.arguments?.getString("name")?: "no name"
            val rounds = it.arguments?.getString("rounds")?: "1"
            UIScreen(name = name, rounds = rounds, movebacktomain = {navcontroller.navigate(route=Screens.MainScreen.route)})
        }
    }
}