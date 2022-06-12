package com.example.nostalgiccarcatalog.detomaso

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData

data class DeTomasoModel(val name: String)

data class PanteraModelUrl(val imageUrl: String)
val panteraUrlList =  mutableStateListOf<PanteraModelUrl>()
val panteraCarList: MutableLiveData<MutableList<PanteraModelUrl>> by lazy { MutableLiveData<MutableList<PanteraModelUrl>>() }