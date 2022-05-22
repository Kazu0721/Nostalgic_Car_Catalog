package com.example.nostalgiccarcatalog.toyota


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.nostalgiccarcatalog.model.ToyotaModel
import com.example.nostalgiccarcatalog.model.ModelUrl
import com.example.nostalgiccarcatalog.model.carList

@Composable
 fun ToyotaCarsScreen(navController: NavController, name: ToyotaModel) {

    val list = carList.observeAsState(listOf<ModelUrl>())
    Scaffold(topBar = {CarsTopBar(navController, name) }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
        ){

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                items(list.value) { item -> PhotoItem(item.imageUrl)
                }
            }

        }
    }
}

@Composable
fun PhotoItem(item: String) {

    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 4.dp),
            Alignment.Center
            ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item)
                    .size(coil.size.Size.ORIGINAL)
                    .build()
            )
            Image(
                painter = painter, contentDescription = "Car",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
@Composable
fun CarsTopBar(navController: NavController, name: ToyotaModel) {
    val carName = name.name

    TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.DarkGray, contentColor = Color.White, elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        },
        title = { Text(carName) },
        actions = {
            IconButton(onClick = { navController.navigate("toyotaCarsReference/${name.name}") }) {
                Icon(Icons.Filled.Share, contentDescription = "Reference" )
            }
        }
    )
}
