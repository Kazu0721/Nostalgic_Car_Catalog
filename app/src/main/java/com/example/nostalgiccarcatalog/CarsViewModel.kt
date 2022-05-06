package com.example.nostalgiccarcatalog

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nostalgiccarcatalog.model.ToyotaModel

class CarsViewModel: ViewModel() {
    val toyotaModelList = mutableStateListOf<ToyotaModel>(
        ToyotaModel("TOYOTA 2300GT"),
        ToyotaModel("TOYOTA SPORTS800")
    )
}