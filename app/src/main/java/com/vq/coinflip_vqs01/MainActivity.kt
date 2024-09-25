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
import androidx.activity.viewModels
import androidx.annotation.Nullable
import androidx.compose.animation.animateColor
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.coroutineScope
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.absoluteValue
import kotlin.math.log
import kotlin.math.round
import kotlin.random.Random
import kotlinx.coroutines.delay


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

        val viewModel by viewModels<ViewFunction>()
        val setFunButton by mutableStateOf(viewModel.settingsViewColOpen)

        enableEdgeToEdge()
        setContent {
            GeneralSite(viewModel)
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

//@Preview
@Composable
fun GeneralSite( viewModel: ViewFunction ) {
    val infiniteTransition = rememberInfiniteTransition()
    val backgroundAnimC1 = infiniteTransition.animateColor(
        Color(0xFF64B5F6), Color(0xFF64B5F6),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 30000
                Color(0xff50a9f2) at 10000
                Color(0x5394c9) at 20000
            }
        )
    ).value
    val backgroundAnimC2 = infiniteTransition.animateColor(
        Color(0xFF0D47A1), Color(0xFF0D47A1),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 45000
                Color(0xFF093d8f) at 15000
                Color(0xFF133d80) at 30000
            }
        )
    ).value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        backgroundAnimC1,
                        backgroundAnimC2
                    )
                )
            )
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopLine(viewModel)
            MiddleField()
            BottomBar(viewModel)
        }
        if (viewModel.settingsViewColOpen > 0 && viewModel.settingsViewColOpen < 4)
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
                OptionsDialog(viewModel)
            }

    }
}

@Composable
fun TopLine(viewModel: ViewFunction) {
    Box (
        modifier = Modifier
            .padding(end = 30.dp, top = 30.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.15f),
        Alignment.TopEnd
    ) {
        SingleIconButton(10, 0, viewModel)
    }
}

@Composable
fun MiddleField() {
    val ctx = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .clickable(
                enabled = true,
                onClick = {
                    Toast
                        .makeText(ctx, "Info: Coin Flipped", Toast.LENGTH_SHORT)
                        .show()

                })
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            Alignment.Center
        ) {
            CoinView()
        }
        Box (
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            Alignment.Center
        ) {
            Text (
                "Click on the screen to flip a coin!",
                style = TextStyle(
                    color = Color(0xadadfdfdfd)
                ),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun BottomBar(viewModel: ViewFunction) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SingleIconButton(1, 0, viewModel)
        SingleIconButton(2, 0, viewModel)
        SingleIconButton(3, 0, viewModel)
    }
}

@Composable
fun OptionsDialog(
    viewModel: ViewFunction
) {
    Box (
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.7f)
            .clip(RoundedCornerShape(50.dp))
            .background(Color(0xffffff).copy(alpha = 0.85f)),
        Alignment.Center
    ) {
        when (viewModel.settingsViewColOpen) {
            1 -> ColorChangeDialog(viewModel)
            2 -> ButtonFaceDialog(viewModel)
            else -> GeneralOptionsOverview(viewModel)
        }
    }
}

@Composable
fun ColorChangeDialog(viewModel: ViewFunction) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(20.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.SpaceBetween,
        //horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(8) { i ->
                SingleIconButton((100 + i), 0, viewModel, 150, 15, 20, Color(0xFFFD2323))
            }
        }
    )
}

@Composable
fun ButtonFaceDialog(viewModel: ViewFunction) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(20.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.SpaceBetween,
        //horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(8) { i ->
                SingleIconButton((100 + i), 0, viewModel, 150, 15, 20, Color(0xFF26A699))
            }
        }
    )
}

@Composable
fun GeneralOptionsOverview(viewModel: ViewFunction) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(20.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.SpaceBetween,
        //horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            items(8) { i ->
                SingleIconButton((100 + i), 0, viewModel, 150, 15, 20, Color(0xFF26A699))
            }
        }
    )
}

/*@Composable
fun SelectionField(viewModel: ViewFunction) {
    SingleIconButton(onClickVal = 20, painterResourceVal = 0, viewModel = viewModel)
}*/

@Composable
fun SingleIconButton(
    onClickVal: Int?,
    painterResourceVal: Int?,
    viewModel: ViewFunction,
    sizerad: Int = 110,
    sizepaddver: Int = 0,
    sizepaddhor: Int = 0,
    colorVal: Color = Color(0xFF26A699),
) {
    val ctx = LocalContext.current
    Button(
        onClick = {
            when (onClickVal) {
                1 -> viewModel.ButtonOne()
                2 -> viewModel.ButtonTwo()
                3 -> viewModel.ButtonTre()
                else -> viewModel.ButtonReload()
            }
                  },
        colors = ButtonDefaults.buttonColors(containerColor = colorVal),
        modifier = Modifier
            .size(width = sizerad.dp, height = sizerad.dp)
            .padding(horizontal = sizepaddhor.dp, vertical = sizepaddver.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun CoinView() {
    val coinFace = R.drawable.coinfront
    val coinBack = R.drawable.coinback
    var CoinSideF: Int
    var CoinSideB: Int

    var CoinVisable by remember { mutableStateOf(coinFace) }

    var coinSize by remember { mutableStateOf(250) }
    var isFlipping by remember { mutableStateOf(false) }
    var animDirection by remember { mutableStateOf(1) }

    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = if (animDirection == 1) 360f else -360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )
    val coinSizeAnimation = infiniteTransition.animateValue(
        initialValue = 250.dp,
        targetValue = 400.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 2000
                250.dp at 0 with LinearEasing
                400.dp at 1000 with LinearEasing
                250.dp at 2000 with LinearEasing
            }
        )
    )


    LaunchedEffect(isFlipping) {
        if (isFlipping == true) {
            CoinSideF = coinFace
            CoinSideB = coinBack

            CoinVisable = CoinSideF
            delay(500)
            CoinVisable = CoinSideB
            delay(500)
            CoinVisable = CoinSideF
            delay(500)
            CoinVisable = CoinSideB
            delay(500)

            CoinSideF = if ((0..1).random() == 1) coinFace else coinBack
            CoinSideB = if (CoinSideF == coinBack) coinFace else coinBack

            animDirection *= -1

            CoinVisable = CoinSideF
            delay(300)
            CoinVisable = CoinSideB
            delay(500)
            CoinVisable = CoinSideF
            delay(500)
            CoinVisable = CoinSideB
            delay(500)


            isFlipping = false
            animDirection *= -1
        }
    }


    Image (
        modifier = Modifier
            .size(coinSize.dp)
            .clickable(
                enabled = true,
                onClick = {
                    isFlipping = !isFlipping
                }
            )
            .graphicsLayer {
                if (isFlipping) {
                    rotationX = rotationAngle.value
                }
            }
            /*.graphicsLayer {
                rotationX = rotationValX.value
                translationX = positionValX.value
            }*/
            .clip(CircleShape),
        painter = painterResource(id = CoinVisable),
        contentDescription = "Hello",
    )
}




/*

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
}*/