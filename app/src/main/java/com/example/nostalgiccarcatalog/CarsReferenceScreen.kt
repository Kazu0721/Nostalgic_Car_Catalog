package com.example.nostalgiccarcatalog

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.lotus.LotusViewModel
import com.example.nostalgiccarcatalog.toyota.ToyotaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun CarsReferenceScreen(navController: NavController, name: String){
    val model = hiltViewModel<ToyotaViewModel>()
    val referenceList = model.reference2300GTList

    val europaModel = hiltViewModel<LotusViewModel>()
    val europaReferenceList = europaModel.europaWebList

    Scaffold(topBar = {ReferenceTopBar(navController, name)}) {
        when(name){
            "TOYOTA 2300GT" -> {DataItems(referenceList){url -> navController.navigate("webView/${url}")}}
            "LOTUS EUROPA" -> {DataItems(europaReferenceList){url -> navController.navigate("webView/${url}")}}
        }
    }
}

@Composable
fun DataItems(dataList: List<String>, itemSelected:  (String) -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column {
            Text(text = " I used it as a reference.", color = Color.White)
            LazyColumn{
                        items(dataList){dataItem -> ReferenceList(dataItem, itemSelected)
                        }
            }
        }
    }

}

@Composable
fun ReferenceList(dataItem: String, itemSelected: (String) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable { itemSelected(dataItem) },
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(dataItem,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }
    }
}

@Composable
fun ReferenceTopBar(navController: NavController, carName: String) {
    val model = hiltViewModel<FirestoreViewModel>()
    val context = Dispatchers.Default
    val scope = CoroutineScope(context)
    TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.DarkGray, contentColor = Color.White, elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()

            }) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        },
        title = { Text("$carName  Reference")}
    )
}
