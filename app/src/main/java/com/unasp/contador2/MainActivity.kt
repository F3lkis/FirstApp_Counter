package com.unasp.contador2

import android.R.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Home()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "Contador")},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = androidx.compose.ui.graphics.Color.Gray)
            )
        }
    ) {
        paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(80.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            SystemCounter()
        }
    }
}


@Composable
fun Counter(value:String){
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = color.black),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SystemCounter(){
    var contador by remember { mutableStateOf(0) }
    Counter("Contador: $contador")

    Button(
        onClick = {
            contador+=1
        },
        modifier = Modifier.background(
            shape = RoundedCornerShape(15.dp),
            color = androidx.compose.ui.graphics.Color.Cyan,


        )
        .padding(
            vertical = 5.dp
        )
        .width(250.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = androidx.compose.ui.graphics.Color.Cyan
        )
    ) {
        Text(
            text = "Aumentar",
            fontSize = 30.sp,
        )
    }

    Button(
        onClick = {
            if (contador > 0){
                contador-=1
            }
        },
        modifier = Modifier.background(
            shape = RoundedCornerShape(15.dp),
            color = androidx.compose.ui.graphics.Color.Red,
        )
        .padding(
            vertical = 5.dp
        )
        .width(250.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = androidx.compose.ui.graphics.Color.Red
        )
    ) {
        Text(
            text = "Decrementar",
            fontSize = 30.sp,
        )
    }

    TextButton(
        onClick = {
            if (contador > 0){
                contador = 0
            }
        }
    ) {
        Text(
            text = "Resetar",
            fontSize = 20.sp,
        )
    }
}

@Preview
@Composable
fun SystemCounterPreview(){
    Home()
}



