package com.example.nostalgiccarcatalog.model

import androidx.compose.runtime.mutableStateListOf
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


data class ToyotaModel(val name: String)

data class  ToyotaWebView (val url: String)

 val dataOne = URLEncoder.encode("https://www.autocar.jp/post/409929", StandardCharsets.UTF_8.toString())
 val dataTwo = URLEncoder.encode("https://kurukura.jp/snasna/170309.html", StandardCharsets.UTF_8.toString())

val referenceList = mutableStateListOf<ToyotaWebView>(
    ToyotaWebView("$dataOne" ),
    ToyotaWebView("$dataTwo")
)