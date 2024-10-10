package com.vq.coinflip_vqs01

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

/* TO-DO: Make color vals vor bg and buttons, make extra button funs, make buttons round ;),
make animation more smooth, better and more coin faces, counter function and display,
make active button highlited and other unuseable... */

class ViewFunction: ViewModel() {
    // Colors

    val ColDefine00 = Color(0xFF000000)
    val ColDefine01 = Color(0xFFFFFFFF)
    val ColDefine02 = Color(0xFF64B5F6) // Transition Top start
    val ColDefine03 = Color(0xFF50A9F2)
    val ColDefine04 = Color(0xFF5394C9) // Transition Top end
    val ColDefine05 = Color(0xFF0D47A1) // Transition Bottom start
    val ColDefine06 = Color(0xFF093d8f)
    val ColDefine07 = Color(0xFF133d80) // Transition Bottom end
    val ColDefine08 = Color(0xADFDFDFD) // Hint Color
    val ColDefine09 = Color(0xFF26A699) // ALIKE !!!
    val ColDefine10 = Color(0xFF)

    val BGColDefine01 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine02 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine03 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine04 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine05 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine06 = arrayOf(
        Color(0xFFFFFDDD),
        Color(0xFFFDDDDD),
        Color(0xFFDDDDDD),
        Color(0xFFAAADDD),
        Color(0xFFABBDDD),
        Color(0xFFBBBDDD),
    )

    val BGColDefine07 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColDefine08 = arrayOf(
        Color(0xFF64B5F6),
        Color(0xFF50A9F2),
        Color(0xFF5394C9),
        Color(0xFF0D47A1),
        Color(0xFF093d8f),
        Color(0xFF133d80),
    )

    val BGColSelection = arrayOf(
        BGColDefine01,
        BGColDefine02,
        BGColDefine03,
        BGColDefine04,
        BGColDefine05,
        BGColDefine06,
        BGColDefine07,
        BGColDefine08,
    )
    var BGSelector by mutableStateOf(0)

    // Colors End

    val CoinFaceDefine = intArrayOf(
        R.drawable.a1,
        R.drawable.a2,
        R.drawable.b1,
        R.drawable.b2,
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.d1,
        R.drawable.d2,
        R.drawable.e1,
        R.drawable.e2,
        R.drawable.f1,
        R.drawable.f2,
        R.drawable.g1,
        R.drawable.g2,
        R.drawable.h1,
        R.drawable.h2
    )

    var activeCoinFace by mutableIntStateOf(0)
    var isFlipping by mutableStateOf(false)

    var coinFlipShowInfo by mutableStateOf(false)
    var numberOfFront by mutableStateOf(0)
    var numberOfBack by mutableStateOf(0)

    var settingsViewColOpen by mutableStateOf(0)
    //private set

    fun ButtonOne() {
        if (settingsViewColOpen == 0)
            settingsViewColOpen = 1
        else
            ButtonBack()
    }

    fun ButtonTwo() {
        if (settingsViewColOpen == 0)
            settingsViewColOpen = 2
        else
            ButtonBack()
    }

    fun ButtonTre() {
        if (settingsViewColOpen == 0)
            settingsViewColOpen = 3
        else
            ButtonBack()
    }

    fun ButtonCoin(inVal: Int) {
        activeCoinFace = (inVal - 100)
        ButtonBack()
        isFlipping = true
    }

    fun BGSelectorfun(inVal: Int) {
        BGSelector = (inVal - 200)
        ButtonBack()
    }

    fun ButtonReset() {
        coinFlipShowInfo = false
        numberOfBack = 0
        numberOfFront = 0
    }

    fun ButtonBack() {
        settingsViewColOpen = 0
    }
}