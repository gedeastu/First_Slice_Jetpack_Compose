package com.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                //val items = arrayOf("SISTEM BASIS DATA 1","SISTEM BASIS DATA 2","SISTEM BASIS DATA 1")
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Gede Astu",
                        //list = items
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,
             modifier: Modifier = Modifier,
             //list:Array<String>
) {
    val items = (1..3).map { "SISTEM BASIS DATA $it" }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(vertical = 20.dp)) {
            Row(
                modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Column{
                    Text(text = "Selamat Pagi", color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 15.sp, fontFamily = FontFamily.SansSerif)
                    Text(text = name, color =  Color.Black, fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
                Button(onClick = { /*TODO*/ },
                    modifier
                        .padding(0.dp)
                        .wrapContentSize(),
                    contentPadding = PaddingValues(0.dp) ,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#EF2F3A"))
                    )) {
                    Row(
                        modifier
                            .height(35.dp)
                            .width(140.dp)
                            .padding(horizontal = 10.dp)
                        , horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                        Text(modifier=Modifier,text = "Mahasiswa", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.White)
                        Surface(
                            modifier
                                .clip(RoundedCornerShape(100.dp))
                                .wrapContentSize(),color = Color.Red){
                            Image(modifier=Modifier.size(30.dp),painter = painterResource(id = R.drawable.mypict_preview_rev_1), contentDescription = "profile")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier) {
                Text(modifier = Modifier.padding(vertical = 20.dp), text = "Jadwal Kuliah Hari ini", color = Color.Black, fontWeight = FontWeight.SemiBold)
                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .horizontalScroll(rememberScrollState()), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    items(items.size){index ->
                        Column(modifier = Modifier
                            .width(300.dp)
                            .padding(end = 10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .height(150.dp)
                            .background(color = Color(android.graphics.Color.parseColor("#D32B28")))
                            .padding(vertical = 10.dp, horizontal = 15.dp)) {
                            Text(text = "${ if(name === "Gede Astu")items[index] else null}", fontWeight = FontWeight.SemiBold, color = Color.White)
                        }
                    }

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //val items = arrayOf("SISTEM BASIS DATA 1","SISTEM BASIS DATA 2","SISTEM BASIS DATA 1")
    ProjectTheme {
        Greeting("Gede Astu",
            //list = items
        )
    }
}