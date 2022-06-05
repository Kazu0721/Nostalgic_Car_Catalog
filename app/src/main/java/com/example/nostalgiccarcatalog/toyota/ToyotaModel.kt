package com.example.nostalgiccarcatalog.toyota

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData



data class ToyotaModel(val name: String)

data class  ToyotaWebView (val url: String)

data class ModelUrl(val imageUrl: String)
val urlList =  mutableStateListOf<ModelUrl>()
val toyotaCarList: MutableLiveData<MutableList<ModelUrl>> by lazy { MutableLiveData<MutableList<ModelUrl>>() }
