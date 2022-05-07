package com.example.nostalgiccarcatalog.toyota


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.model.ToyotaModel

@Composable
fun ToyotaScreen(navController: NavController, model: ToyotaViewModel){

    Scaffold(topBar = { ToyotaTopBar(navController) }){
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn{
                items(model.toyotaModelList){list -> ToyotaList(navController, items = list)}
            }
        }
    }
}
@Composable
fun ToyotaList(navController: NavController, items: ToyotaModel) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable {
            navController.navigate("toyotaCar/${items.name}")
        },
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Green
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(items.name)
        }
    }
}

@Composable
fun ToyotaTopBar(navController: NavController) {
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
        title = { Text("TOYOTA")},
        elevation = 0.dp)
}


