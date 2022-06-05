package com.example.nostalgiccarcatalog

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nostalgiccarcatalog.lotus.EuropaModelUrl
import com.example.nostalgiccarcatalog.lotus.europaCarList
import com.example.nostalgiccarcatalog.lotus.europaUrlList
import com.example.nostalgiccarcatalog.toyota.ModelUrl
import com.example.nostalgiccarcatalog.toyota.toyotaCarList
import com.example.nostalgiccarcatalog.toyota.urlList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirestoreViewModel @Inject constructor(): ViewModel() {
    suspend fun getUrl(itemName: String){
        val name = itemName.lowercase().replace(" ","")
        viewModelScope.launch{
            launch {
                val db = Firebase.firestore
                db.collection("$name")
                    .orderBy("imageUrl")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            val url =document.getString("imageUrl")

                            when(itemName){
                                "TOYOTA 2300GT" ->{ url?.let { urlList.add(ModelUrl(it)) }
                                    toyotaCarList.value = urlList}
                                "LOTUS EUROPA" -> {url?.let { europaUrlList.add(EuropaModelUrl(it))}
                                    europaCarList.value = europaUrlList}
                            }
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w(ContentValues.TAG, "Error getting documents.", exception)
                    }
            }
        }.join()
    }
}