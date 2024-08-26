package com.vq.coinflip_vqs01

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vq.coinflip_vqs01.ui.theme.CoinFlip_VQS01Theme


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.ui.res.imageResource

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinFlip_VQS01Theme {
                var coinstate = remember { mutableStateOf((0..1).random()) }
                val coinFace = when(coinstate.value) {
                    0 -> R.drawable.coinback
                    else -> R.drawable.coinfront
                }

                Box(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = {
                                coinstate.value = (0..1).random()
                                Log.i("TAG", "coinFace: $coinFace, coinState: $coinstate \n back: ${R.drawable.coinback} front: ${R.drawable.coinfront}")
                            })
                        .fillMaxSize()
                        .background(color = Color.Cyan)
                ) {
                    ResetButton()

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                    ) {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            CoinView(coinFace)

                            if (1 == 1) {
                                Text(
                                    text = "Press to flip the coin!",
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Italic,
                                    color = Color.DarkGray,
                                    modifier = Modifier
                                        .padding(top = 60.dp)
                                )
                            }
                        }
                    }
                    
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.BottomCenter)
                            .padding(bottom = 25.dp),
                        Arrangement.SpaceAround
                    ) {
                        BottomButton()
                        BottomButton()
                        BottomButton()
                    }
                }
            }
        }
    }
}

@Composable
fun ResetButton() {
    val ctx = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp, top = 25.dp),
        contentAlignment = Alignment.TopEnd)
    {
        Button(onClick = {
            Toast.makeText(ctx, "Reset Coin stats", Toast.LENGTH_SHORT).show()
        }) {
            Column(
                modifier = Modifier
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)

                )
                Spacer(Modifier.height(10.dp))

                Text(
                    "Reset",
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )

            }
        }
    }
}

@Composable
fun BottomButton() {
    val ctx = LocalContext.current
    Button(onClick = {
        Toast.makeText(ctx, "Reset Coin stats", Toast.LENGTH_SHORT).show()
    }) {
        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)

            )
            Spacer(Modifier.height(10.dp))

            Text(
                "Reset",
                style = TextStyle(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )

        }
    }
}

@Composable
fun CoinView(coinFace: Int) {
    Image(
        painter = painterResource(id = coinFace),
        contentDescription = "CoinFront",
        //contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(250.dp)
            .clip(CircleShape),
        alignment = Alignment.Center
    )
}