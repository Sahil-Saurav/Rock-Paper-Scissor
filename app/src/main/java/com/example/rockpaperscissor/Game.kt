package com.example.rockpaperscissor

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class Game {
    /*
    1 -> Rock
    2-> Paper
    3-> Scissor
     */

    fun run(player:Int,comp:Int):String{
        val result :String = if(player==comp){
            "tie"
        }else if (player==1 && comp==2){
            "lose"
        }else if (player==1 && comp==3){
            "win"
        }else if (player==2 && comp==1){
            "win"
        }else if (player==2 && comp==3){
            "lose"
        }else if (player==3 && comp==1){
            "lose"
        }else if (player==3 && comp==2){
            "win"
        }else{
            "Invalid Input"
        }
        return result
    }
}
