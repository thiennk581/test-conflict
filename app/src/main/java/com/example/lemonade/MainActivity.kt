package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun BannerLemonApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Yellow)
    ) {
        Text(
            text = "Lemonade",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    val forFun = "Thien them vao"
    val count = remember {
        mutableStateOf(0)
    }
    if (count.value > 5) count.value = 0
    val image = when(count.value.toInt()) {
        0 -> R.drawable.lemon_tree
        4 -> R.drawable.lemon_drink
        5 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_squeeze
    }
    val content = when(count.value) {
        0 -> R.string.lemon_tree
        4 -> R.string.lemonade
        5 -> R.string.empty_glass
        else -> R.string.lemon
    }
    Column(
        modifier = modifier.clickable { ++count.value },
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = content),
            modifier = Modifier
                .size(300.dp)
                .background(
                    color = Color(120, 235, 210),
                    shape = RoundedCornerShape(40.dp)
                )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(id = content),
            fontSize = 12.sp
        )
        Button(onClick = {}) {
            Text(text = "ahihi")
            OutlinedTextField(value = "", onValueChange = {})
        }
    }
}

fun conflictTestByThien() {
    print("Thienn thay doi lan 3")
    val a = 3;

}
fun conflictByGiap() {
    print("Giap thay doi lan 3")
    val a = 3;

}
fun conflictByGiap4() {
    print("Giap thay doi lan 4")
    val a = 3;

}
fun thisFunctionOfGiap(){
    print("kasjdhfjkshfjkdf")
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        BannerLemonApp()
        Lemonade(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()

        )
    }
}