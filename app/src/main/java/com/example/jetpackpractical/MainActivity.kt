package com.example.jetpackpractical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpackpractical.ui.theme.JetpackPracticalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            JetpackPracticalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black // Netflix dark theme
                ) {
//                    NetflixHomeScreen()
                    LearnRowColumnBox()
                }
            }
        }
    }
}

@Composable
fun NetflixHomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Netflix Logo
        Image(
            painter = painterResource(id = R.drawable.netflix_logo) ,
            contentDescription = "Netflix Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(16.dp)
        )

        // Featured Movie Banner
        Image(
            painter =  painterResource(id = R.drawable.featured_movie) ,
            contentDescription = "Featured Movie",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        // Movie List
        Text(
            text = "Popular on Netflix",
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )

        MovieRow()
    }
}

@Composable
fun MovieRow() {
    val movieList = listOf(
        R.drawable.movie1, R.drawable.movie2,R.drawable.movie3,R.drawable.movie4,R.drawable.movie5
    )

    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(movieList.size) { index ->
            Image(
                painter = painterResource(id = movieList[index]) ,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .width(120.dp)
                    .height(180.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun LearnRowColumnBox() {
//    Text(text = "Hello Column")
//    Text(text = "Hello Column")
//    Text(text = "Hello Column")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello Column 1")
        Text(text = "Hello Column 2")
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello Column 1")
        Text(text = "Hello Column 2")
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.height(300.dp).width(300.dp).background(Color.Blue)) {
            Text(
                text = "Hello Box",
                modifier = Modifier.align(Alignment.Center),
                Color.White,
                fontSize = 30.sp
            )
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PreviewNetflixHomeScreen() {
        JetpackPracticalTheme {
            NetflixHomeScreen()
        }
    }
}
