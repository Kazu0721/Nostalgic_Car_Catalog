package com.example.nostalgiccarcatalog



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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.detomaso.DeTomasoModel
import com.example.nostalgiccarcatalog.detomaso.DeTomasoViewModel
import com.example.nostalgiccarcatalog.detomaso.panteraUrlList
import com.example.nostalgiccarcatalog.lotus.LotusModel
import com.example.nostalgiccarcatalog.lotus.LotusViewModel
import com.example.nostalgiccarcatalog.lotus.europaUrlList
import com.example.nostalgiccarcatalog.toyota.ToyotaModel
import com.example.nostalgiccarcatalog.toyota.ToyotaViewModel
import com.example.nostalgiccarcatalog.toyota.urlList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
 fun CarScreen(navController: NavController, name: String){

    val toyotaViewModel = hiltViewModel<ToyotaViewModel>()
    val lotusViewModel = hiltViewModel<LotusViewModel>()
    val detomasoViewModel = hiltViewModel<DeTomasoViewModel>()

    Scaffold(topBar = { CarTopBar(navController, name) }){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)) {
            LazyColumn{
                when(name){
                    "TOYOTA" -> {
                        items(toyotaViewModel.toyotaModelList){list -> ToyotaNameList(navController, items = list)}
                    }
                    "LOTUS" -> {
                        items(lotusViewModel.lotusModelList){list -> LotusNameList(navController, items = list)}
                    }
                    "DE TOMASO" -> {
                        items(detomasoViewModel.detomasoModelList){list -> DeTomasoNameList(navController, items = list)}
                    }
                }

            }
        }
    }
}

@Composable
fun DeTomasoNameList(navController: NavController, items: DeTomasoModel) {
    val model = hiltViewModel<FirestoreViewModel>()
    val itemName = items.name

    Log.d("PANTERA_NAME", "$itemName")

    val context = Dispatchers.Default
    val scope = CoroutineScope(context)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable {
            scope.launch {
                panteraUrlList.clear()
                model.getUrl(itemName)
                launch(Dispatchers.Main) {
                    navController.navigate("itemsPhoto/$itemName")
                }
            }
        },
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(
                items.name,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }
    }
}

@Composable
fun LotusNameList(navController: NavController, items: LotusModel) {
    val model = hiltViewModel<FirestoreViewModel>()
    val itemName = items.name

    val context = Dispatchers.Default
    val scope = CoroutineScope(context)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable {
            scope.launch {
                europaUrlList.clear()
                model.getUrl(itemName)
                launch(Dispatchers.Main) {
                    navController.navigate("itemsPhoto/$itemName")
                }
            }
        },
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(
                items.name,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }
    }
}

@Composable
fun ToyotaNameList(navController: NavController, items: ToyotaModel) {
    val model2 = hiltViewModel<FirestoreViewModel>()
    val itemName = items.name

    val context = Dispatchers.Default
    val scope = CoroutineScope(context)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable {
            scope.launch {
                urlList.clear()
                model2.getUrl(itemName)
                launch(Dispatchers.Main) {
                    navController.navigate("itemsPhoto/$itemName")
                }
            }
        },
        shape = RoundedCornerShape(10),
        backgroundColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        {
            Text(
                items.name,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
        }
    }
}

@Composable
fun CarTopBar(navController: NavController, name: String) {
    TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.DarkGray, contentColor = Color.White,  elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        },
        title = { Text("$name")}
    )
}


