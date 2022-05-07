package com.example.nostalgiccarcatalog.toyota

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nostalgiccarcatalog.model.ToyotaModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToyotaViewModel @Inject constructor() : ViewModel() {
    val toyotaModelList = mutableStateListOf<ToyotaModel>(
        ToyotaModel("TOYOTA 2300GT"),
        ToyotaModel("TOYOTA SPORTS800")
    )
}