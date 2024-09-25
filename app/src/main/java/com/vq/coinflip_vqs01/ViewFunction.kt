package com.vq.coinflip_vqs01

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

/* TO-DO: Make color vals vor bg and buttons, make extra button funs, make buttons round ;),
make animation more smooth, better and more coin faces, counter function and display,
make active button highlited and other unuseable... */

class ViewFunction: ViewModel() {
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

    fun ButtonBack() {
        settingsViewColOpen = 0
    }

    fun ButtonReload() {
        /*TO DO*/
    }
}