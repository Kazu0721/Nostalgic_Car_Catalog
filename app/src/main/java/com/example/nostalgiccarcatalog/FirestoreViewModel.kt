package com.example.nostalgiccarcatalog

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nostalgiccarcatalog.model.ModelUrl
import com.example.nostalgiccarcatalog.model.urlList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirestoreViewModel @Inject constructor(): ViewModel() {
    fun getUrl(itemName: String){
        val name = itemName.lowercase().replace(" ","")
        val db = Firebase.firestore
        db.collection("$name")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val url =document.getString("imageUrl")
                    url?.let { urlList.add(ModelUrl(it)) }
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
}