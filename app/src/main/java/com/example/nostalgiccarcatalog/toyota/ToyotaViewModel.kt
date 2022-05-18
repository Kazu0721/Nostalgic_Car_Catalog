package com.example.nostalgiccarcatalog.toyota

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nostalgiccarcatalog.model.ModelUrl
import com.example.nostalgiccarcatalog.model.ToyotaModel
import com.example.nostalgiccarcatalog.model.ToyotaWebView
import com.example.nostalgiccarcatalog.model.urlList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class ToyotaViewModel @Inject constructor() : ViewModel() {
    val toyotaModelList = mutableStateListOf(
        ToyotaModel("TOYOTA 2300GT"),
        ToyotaModel("TOYOTA SPORTS 800")
    )

    private val dataOne = URLEncoder.encode("https://www.autocar.jp/post/409929", StandardCharsets.UTF_8.toString())
    private val dataTwo = URLEncoder.encode("https://kurukura.jp/snasna/170309.html", StandardCharsets.UTF_8.toString())

    val referenceList = mutableStateListOf(
        ToyotaWebView(dataOne),
        ToyotaWebView(dataTwo)
    )

}


