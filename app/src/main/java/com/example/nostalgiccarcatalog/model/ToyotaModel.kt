package com.example.nostalgiccarcatalog.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow


data class ToyotaModel(val name: String)

data class  ToyotaWebView (val url: String)

data class ModelUrl(val imageUrl: String)
val urlList =  mutableStateListOf<ModelUrl>()
val carList: MutableLiveData<MutableList<ModelUrl>> by lazy { MutableLiveData<MutableList<ModelUrl>>() }
