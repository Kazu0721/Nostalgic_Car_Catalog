package com.example.nostalgiccarcatalog.toyota


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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
    val reference2300GTList = listOf(dataOne, dataTwo)




}


