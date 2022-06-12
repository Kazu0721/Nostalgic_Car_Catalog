package com.example.nostalgiccarcatalog.detomaso

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class DeTomasoViewModel @Inject constructor(): ViewModel() {
    val detomasoModelList = mutableStateListOf(
        DeTomasoModel("DE TOMASO PANTERA")
    )

    private val data1 = URLEncoder.encode("https://motorz.jp/race/car/93963/", StandardCharsets.UTF_8.toString())
    private val data2 = URLEncoder.encode("https://web.motormagazine.co.jp/_ct/17292929", StandardCharsets.UTF_8.toString())
    private val data3 = URLEncoder.encode("https://commons.wikimedia.org/wiki/File:DeTomasoPanteraBlack.jpg", StandardCharsets.UTF_8.toString())
    private val data4 = URLEncoder.encode("https://autoc-one.jp/lamborghini/countach/special-5009525/photo/0010.html", StandardCharsets.UTF_8.toString())
    private val data5 = URLEncoder.encode("https://scuderia-sportiva-colonia.de/en/cars/536-de-tomaso-pantera#68", StandardCharsets.UTF_8.toString())
    private val data6 = URLEncoder.encode("https://www.dreamstime.com/photos-images/detomaso.html", StandardCharsets.UTF_8.toString())
    private val data7 = URLEncoder.encode("https://www.thedrive.com/news/23454/this-detomaso-pantera-gt5-for-sale-is-the-holy-grail-of-panteras", StandardCharsets.UTF_8.toString())
    private val data8 = URLEncoder.encode("https://www.alamy.com/stock-photo/detomaso.html", StandardCharsets.UTF_8.toString())

    val referencePanteraList = listOf(data1, data2, data3, data4, data5, data6, data7, data8)
}