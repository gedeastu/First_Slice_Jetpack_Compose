package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Astu")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var condition by remember { mutableStateOf(false) }
    Image(painter = painterResource(id = R.drawable.rotterdam), contentDescription = "Background Rotterdam", modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    Box(
        modifier
            .fillMaxSize()
            .padding(40.dp),contentAlignment = Alignment.Center) {
        Column(
            modifier
                .background(Color.Blue)
                .size(300.dp)
                .border(width = 2.dp, color = Color.DarkGray)
                .align(alignment = Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Hello $name!",
                color= Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp
            )
            Text(
                text = "Some other text!",
                color= Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp
            )
        }

        Row(
            modifier
                .fillMaxWidth()
                .height(50.dp)
                , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                condition = !condition
            }) {
                Icon(imageVector = Icons.Default.Home , contentDescription = "Email", modifier.clickable {  })
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Email , contentDescription = "Email", modifier.clickable {  })
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Share , contentDescription = "Share", modifier.clickable {  })
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Build , contentDescription = "Build", modifier.clickable {  })
            }
        }
        Column(
                modifier
                    .background(if (condition) Color.Green else Color.Blue)
                    .size(300.dp)
                    .border(width = 2.dp, color = Color.DarkGray)
                    .align(alignment = Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier,
                    text = "Status : ${if (condition) "Online" else "Offline"}",
                    color= (if (condition) Color.Blue else Color.White),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTheme {
        Greeting("Astu")
    }
}