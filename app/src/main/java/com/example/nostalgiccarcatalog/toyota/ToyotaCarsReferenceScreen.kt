package com.example.nostalgiccarcatalog.toyota

import android.util.Log
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
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.model.ToyotaModel
import com.example.nostalgiccarcatalog.model.ToyotaWebView
import com.example.nostalgiccarcatalog.model.referenceList
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ToyotaCarsReferenceScreen(navController: NavController, name: ToyotaModel){

    val carName = name.name

    Scaffold(topBar = {ReferenceTopBar(navController, carName)}) {
        DataItems(carName, referenceList){url -> navController.navigate("webView/${url.url}")}

    }
}

@Composable
fun DataItems(carName: String, datas: List<ToyotaWebView>, itemSelected:  (url: ToyotaWebView) -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column {
            Text(text = "I used it as a reference.", color = Color.White)
            LazyColumn{
                when(carName) {
                    "TOYOTA 2300GT" -> {
                        items(datas){dataItem -> ReferenceList(dataItem, itemSelected)}
                    }
                }
            }
        }
    }

}

@Composable
fun ReferenceList(dataItem: ToyotaWebView, itemSelected: (url: ToyotaWebView) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable{itemSelected(dataItem)},
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(dataItem.url,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }
    }
}

@Composable
fun ReferenceTopBar(navController: NavController, carName: String) {
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
