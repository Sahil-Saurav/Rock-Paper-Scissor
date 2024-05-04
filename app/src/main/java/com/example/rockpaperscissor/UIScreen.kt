package com.example.rockpaperscissor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rockpaperscissor.ui.theme.Purple40
import com.example.rockpaperscissor.ui.theme.Purple80
import com.example.rockpaperscissor.ui.theme.PurpleGrey40
import com.example.rockpaperscissor.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun UIScreen(name:String,rounds:String,movebacktomain:()->Unit,modifier:Modifier=Modifier){
    var player by remember { mutableIntStateOf(0) }
    var comp by remember { mutableIntStateOf(0) }
    var result by remember { mutableStateOf("")}
    var currRounds by remember { mutableIntStateOf(0) }
    var wins by remember { mutableIntStateOf(0) }
    var lost by remember { mutableIntStateOf(0) }
    Column(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = AbsoluteAlignment.Left) {
        Text(
            modifier = Modifier.background(Color(Purple80.value)),
            text = " Rock Paper Scissor ",
            fontWeight = FontWeight.Bold,
            fontSize = 42.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            color = Color(0xff481267))
    }
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello!! $name",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Pick Your Choice",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic)
        Spacer(modifier.height(25.dp))
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ElevatedCard(onClick = {player=1
                                   comp=(1..3).random()
                                   result=Game().run(player,comp)
                                   currRounds++
                                   if(result=="win"){
                                       wins++
                                   }else if(result=="lose"){
                                       lost++
                                   } },
                colors = CardDefaults.cardColors(Color(Purple80.value)),
                modifier = Modifier.height(80.dp)){
                Text(text = "Rock", fontSize = 40.sp, color = Color(0xff481267),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    modifier=Modifier.padding(10.dp))
            }
            ElevatedCard(onClick = {player=2
                                    comp=(1..3).random()
                                    result=Game().run(player,comp)
                                   currRounds++
                if(result=="win"){
                    wins++
                }else if(result=="lose"){
                    lost++
                } },
                colors = CardDefaults.cardColors(Color(Purple80.value)),
                modifier = Modifier.height(80.dp)){
                Text(text = "Paper", fontSize = 40.sp, color = Color(0xff481267),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    modifier=Modifier.padding(10.dp))
            }
            ElevatedCard(onClick = {player=3
                                    comp=(1..3).random()
                                    result=Game().run(player,comp)
                                   currRounds++
                if(result=="win"){
                    wins++
                }else if(result=="lose"){
                    lost++
                } },
                colors = CardDefaults.cardColors(Color(Purple80.value)),
                modifier = Modifier.height(80.dp)){
                Text(text = "Scissor", fontSize = 40.sp, color = Color(0xff481267),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    modifier=Modifier.padding(10.dp))
            }
        }
        //Text(text = "Result : $result")
        if(result!=""){
            AlertDialog(containerColor = Color(Purple80.value),modifier = Modifier.fillMaxWidth(),onDismissRequest = {result=""}, confirmButton = {
                Button(modifier = Modifier.background(color = Color(0xff481267),shape = RoundedCornerShape(100)),
                    onClick = {result=""},
                    colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                    Text(text = "Continue!!")
                }
            },
                title = { Text(text = "Result of Your Choice!!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    color = Color(0xff481267))},
                text = {
                    Column {
                        if(comp==1){
                            Text(text = "Comp Picked: Rock",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xff481267))
                        }else if (comp==2){
                            Text(text = "Comp Picked: Paper",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xff481267))
                        }else{
                            Text(text = "Comp Picked Scissor",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xff481267))
                        }
                        if(result!="tie"){
                            Text(text = "You $result!!",
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                fontFamily = FontFamily.Monospace,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xff481267))
                        }else{
                            Text(text = "It's a Tie!!",
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp,
                                fontFamily = FontFamily.Monospace,
                                fontStyle = FontStyle.Italic,
                                color = Color(0xff481267))
                        }
                    }
                    })
        }
        if(currRounds==rounds.toInt() && result==""){
            AlertDialog(containerColor = Color(Purple80.value),modifier = Modifier.fillMaxWidth(),
                onDismissRequest = {movebacktomain()},
                confirmButton = { Button(onClick = {movebacktomain()},modifier = Modifier.background(color = Color(0xff481267),
                    shape = RoundedCornerShape(100)),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                    Text(text = "Go To Main Menu")}},
                title = { Text(text = "Score-Card",fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    color = Color(0xff481267))},
                text = { Column {
                    Text(text = "Wins: $wins",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Loses: $lost",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    if (wins>lost){
                        Text(text = "Congratulations!! You're Winner!!",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Cursive,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xff481267))
                    }else if (lost>wins){
                        Text(text = "Hard Luck!! Try Again!!",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Cursive,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xff481267))
                    }else{
                        Text(text = "It's Draw!!",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            fontFamily = FontFamily.Cursive,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xff481267))
                    }
                }})
        }
        Text(text = rounds)
    }

}




@Composable
@Preview(showBackground = true)
fun UIPreview(){
    UIScreen("Sahil","3",{})
}