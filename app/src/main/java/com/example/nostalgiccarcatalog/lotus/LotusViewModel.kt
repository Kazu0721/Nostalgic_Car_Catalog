package com.example.nostalgiccarcatalog.lotus

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class LotusViewModel @Inject constructor(): ViewModel(){
    val lotusModelList = mutableStateListOf(
        LotusModel("LOTUS EUROPA"),
        LotusModel("LOTUS ELAN")
    )
    private val europaData1 = URLEncoder.encode( "https://notoriousluxury.com/2017/05/06/lotus-legends-europa-twin-cam-ideology/", StandardCharsets.UTF_8.toString())
    private val europaData2 = URLEncoder.encode( "https://drive-my.com/lotus-europa-racing-car-type-47-road-test/", StandardCharsets.UTF_8.toString())
    private val europaData3 = URLEncoder.encode(   "https://carsmeet.jp/2019/07/29/114501/", StandardCharsets.UTF_8.toString())
    val europaWebList = listOf(europaData1, europaData2, europaData3)

}