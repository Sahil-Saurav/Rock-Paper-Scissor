package com.example.rockpaperscissor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun MainScreen(movetoui:(String,String)->Unit){
    var name by remember { mutableStateOf("")}
    var rounds by remember { mutableIntStateOf(1) }
    var showMenu by remember { mutableStateOf(false)}
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Player Name:",
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            color = Color(0xff481267)
        )
        OutlinedTextField(value = name, onValueChange = {name=it},
            label = { Text(text = "Enter Your Name")},
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color(0xff481267),
                unfocusedBorderColor = Color(0xff481267),
                unfocusedTextColor = Color(0xff481267),
                focusedTextColor = Color(0xff481267),
                cursorColor = Color(0xff481267),
                focusedLabelColor = Color(0xff481267),
                unfocusedLabelColor = Color(0xff481267)))
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Rounds:",
                fontWeight = FontWeight.Bold,
                fontSize = 33.sp,
                fontFamily = FontFamily.Cursive,
                fontStyle = FontStyle.Italic,
                color = Color(0xff481267))
            Spacer(modifier = Modifier.width(20.dp))
            Button(modifier = Modifier.background(color = Color(0xff481267),
                shape = RoundedCornerShape(100)),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = {showMenu=true}) {
                Text(text = "$rounds", fontSize = 20.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
            Box(){
                DropdownMenu(modifier = Modifier.background(color = Color(Purple80.value)),expanded =showMenu , onDismissRequest = {showMenu=false}) {
                    DropdownMenuItem(text = { Text(text = "1")},
                        onClick = {rounds=1
                            showMenu=false},)
                    DropdownMenuItem(text = { Text(text = "3")},
                        onClick = {rounds=3
                            showMenu=false})
                    DropdownMenuItem(text = { Text(text = "5")},
                        onClick = {rounds=5
                            showMenu=false})
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(modifier = Modifier.background(color = Color(0xff481267),
            shape = RoundedCornerShape(100)),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            onClick = {movetoui(name,rounds.toString())}) {
            Text(text = "Play", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen({_,_->})
}