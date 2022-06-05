package com.example.nostalgiccarcatalog.lotus

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData

data class LotusModel(val name: String)

data class  EuropaWebView (val url: String)

data class EuropaModelUrl(val imageUrl: String)
val europaUrlList =  mutableStateListOf<EuropaModelUrl>()
val europaCarList: MutableLiveData<MutableList<EuropaModelUrl>> by lazy { MutableLiveData<MutableList<EuropaModelUrl>>() }