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
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
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
import kotlin.math.absoluteValue
import kotlin.math.log
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    // change Type of following vars to what they become
    private var headCounts: Int = 0
    private var numCounts: Int = 0
    private var setInState: Int = 0
    private var activeColorScheme: Int = 0
    private var optionSettingFrees: Int = 0 // gib dem zeugs bitte no a paar options
    private var activeCoinFace: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeneralSite()
        }
    }
}

/*

CoinFlip_VQS01Theme {
                var coinstate = remember { mutableStateOf((0..1).random()) }
                val coinBack = R.drawable.coinback
                val coinFace = R.drawable.coinfront

                Box(
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClick = {
                                Log.i("TAG", "Hi")
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
                            CoinView(coinFace, coinBack, 100f)

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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp)
                        .padding(top = 150.dp, bottom = 200.dp)
                        .background(color = Color.White),
                    /* shape TO DO */
                ){

                }
            }


*/


// TO DO: Alles ab hier einzelne Elemente -> in einzelne Files übertragen!

@Preview
@Composable
fun GeneralSite() {
    Box(
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = {
                    Log.i("TAG", "Hi")
                })
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopLine()
            MiddleField()
            BottomBar()
        }
        if (true)
            OptionsDialog()
    }
}

@Composable
fun TopLine() {
    Box(modifier = Modifier.padding(end = 30.dp, top = 30.dp), Alignment.TopEnd) {
        SingleIconButton(0, 0, "0")
    }
}

@Composable
fun MiddleField() {
    Box(modifier = Modifier, Alignment.Center) {
        CoinView()
    }
    Box(modifier = Modifier.padding(top = 50.dp), Alignment.Center) {
        Text(text = "click to spin...")
    }
}

@Composable
fun BottomBar() {
    Row (
        modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SingleIconButton(0, 0, "0")
        SingleIconButton(0, 0, "0")
        SingleIconButton(0, 0, "0")
    }
}

@Composable
fun OptionsDialog() {
    Box(modifier = Modifier
        .fillMaxWidth(0.9f)
        .fillMaxHeight(0.7f)
        .background(Color(0xffffffa5)),
        Alignment.Center
    ) {
        when (1) {
            1 -> ColorChangeDialog()
            2 -> ButtonFaceDialog()
            else -> GeneralOptionsOverview()
        }
    }
}

@Composable
fun ColorChangeDialog() {
    // in Color Change
}

@Composable
fun ButtonFaceDialog() {
    // in Button Face Change
}

@Composable
fun GeneralOptionsOverview() {
    // siaht ma no, was do ine kummt...
}

@Composable
fun SelectionField() {
    // Buttons für Auswahl in Menüs
}

@Composable
fun SingleIconButton(
    onClickVal: Int?,
    painterResourceVal: Int?,
    descriptionVal: String?
) {
    val ctx = LocalContext.current
    Button(onClick = {
        Toast.makeText(ctx, "Info: Button pressed", Toast.LENGTH_SHORT).show()
    }) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
        )
    }
}

@Composable
fun CoinView() {
    // this is the view of the coin...
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
fun CoinView(
    coinFaceOrigin: Int,
    coinBackOrigin: Int,
    originCoinSize: Float,
) {
    /*var sizeState by remember {
        mutableStateOf(originCoinSize)
    }
    var rotationState by remember {
        mutableStateOf(0f)
    }*/
    var coinFace by remember {
        mutableStateOf(coinFaceOrigin)
    }
    var coinBack by remember {
        mutableStateOf(coinBackOrigin)
    }

    var currentRotation by remember { mutableStateOf(0f) }
    var currentSize by remember { mutableStateOf(originCoinSize) }
    var isPlaying by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(currentRotation) }
    val size = remember { Animatable(currentSize) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            if (rotation.value >= 800f) !isPlaying
            Log.i("anim State", "1")
            rotation.animateTo(
                targetValue = currentRotation + 90f,
                animationSpec = RepeatableSpec(
                    animation = tween(
                        300,
                        easing = EaseInOut),
                    repeatMode = RepeatMode.Restart,
                    iterations = 9
                )
            ) {
                currentRotation = value
            }
            size.animateTo(
                targetValue = currentSize + originCoinSize,
                animationSpec = tween(
                    durationMillis = 2700,
                    easing = EaseInOut
                )
            ) {
                currentSize = value
            }
        } else {
            Log.i("anim State", "3")
            if (currentSize >= originCoinSize) {
                if ((0..1).random() == 0) {
                    var newCoinFace = coinBack
                    coinBack = coinFace
                    coinFace = newCoinFace
                    Log.i("anim State", "IF")
                }
                rotation.animateTo(
                    targetValue = currentRotation - 90f,
                    animationSpec = RepeatableSpec(
                        animation = tween(
                            300,
                            easing = EaseInOut),
                        repeatMode = RepeatMode.Restart,
                        iterations = 9
                    )
                ) {
                    currentRotation = value
                }
                size.animateTo(
                    targetValue = currentSize - originCoinSize,
                    animationSpec = tween(
                        durationMillis = 2700,
                        easing = EaseInOut
                    )
                ) {
                    currentSize = value
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .clickable(
                enabled = true,
                onClick = {
                    isPlaying = true
                    Log.i("TAG", "Front $coinFace $coinBack")
                })
            .fillMaxSize()
            .background(color = Color.Green)
    ) {
        Image(
            painter = painterResource(id = if (rotation.value >= 270f || rotation.value <= 90f) coinFace else coinBack),
            contentDescription = "CoinFront",
            //contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size.value.dp)
                .clip(CircleShape)
                .graphicsLayer {
                    rotationY = rotation.value
                },
            alignment = Alignment.Center
        )
    }
}