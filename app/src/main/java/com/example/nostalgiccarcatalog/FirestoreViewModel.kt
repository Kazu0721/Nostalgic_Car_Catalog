package com.example.nostalgiccarcatalog

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nostalgiccarcatalog.model.ModelUrl
import com.example.nostalgiccarcatalog.model.carList
import com.example.nostalgiccarcatalog.model.urlList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirestoreViewModel @Inject constructor(): ViewModel() {
    suspend fun getUrl(itemName: String){
        val name = itemName.lowercase().replace(" ","")
        urlList.clear()
        viewModelScope.launch{
            launch {
                val db = Firebase.firestore
                db.collection("$name")
                    .orderBy("imageUrl")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            val url =document.getString("imageUrl")
                            url?.let { urlList.add(ModelUrl(it)) }
                            carList.value = urlList
                            Log.d("URL_LIST", "${carList.value}")
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w(ContentValues.TAG, "Error getting documents.", exception)
                    }
            }
        }.join()
    }
}