package com.example.nostalgiccarcatalog.toyota


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.io.InputStream

@Composable
fun ToyotaCarsScreen(navController: NavController, name: ToyotaModel) {

    Log.d("NAME: ", "$name")

    var tsList: ArrayList<Bitmap> = ArrayList()
    val context = LocalContext.current
    val am = context.assets
    var inp: InputStream

   var files = am.list("${name.name}")
    for (i in files!!.indices){
        inp = am.open("${name.name}" + "/" + files[i])
        val bitmap = BitmapFactory.decodeStream(inp)
        tsList.add(i, bitmap)
    }
    Scaffold(topBar = { Toyota2300GTTopBar(navController, name) }) {
        LazyColumn(
           modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(tsList) { item -> PhotoItem( item = item)
            }
        }
    }
}

@Composable
fun PhotoItem(item: Bitmap) {
    Column {
        Box(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp),
            Alignment.Center
            ) {
            Image(
                item.asImageBitmap(), contentDescription = "ZZZ"
            )
        }
    }
}
@Composable
fun Toyota2300GTTopBar(navController: NavController, name: ToyotaModel) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        title = { Text("${name.name}") },
        elevation = 0.dp
    )
}