package com.example.nostalgiccarcatalog.model

import androidx.compose.runtime.mutableStateListOf


data class ToyotaModel(val name: String)

data class  ToyotaWebView (val url: String)

data class ModelUrl(val imageUrl: String)
val urlList =  mutableStateListOf<ModelUrl>()