package com.example.nostalgiccarcatalog.toyota

import androidx.compose.runtime.mutableStateListOf

data class ToyotaModel(val name: String)
val toyotaModelList = mutableStateListOf<ToyotaModel>(
    ToyotaModel("TOYOTA 2300GT"),
    ToyotaModel("TOYOTA SPORTS 800")
    )
