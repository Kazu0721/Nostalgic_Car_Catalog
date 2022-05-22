package com.example.nostalgiccarcatalog.toyota



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
import com.example.nostalgiccarcatalog.FirestoreViewModel
import com.example.nostalgiccarcatalog.model.ToyotaModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
 fun ToyotaScreen(navController: NavController, model: ToyotaViewModel, name: String){

    Scaffold(topBar = { ToyotaTopBar(navController) }){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)) {
            LazyColumn{
                items(model.toyotaModelList){list -> ToyotaList(navController, items = list)}
            }
        }
    }
}
@Composable
fun ToyotaList(navController: NavController, items: ToyotaModel) {
    val model2 = hiltViewModel<FirestoreViewModel>()
    val itemName = items.name

    val context = Dispatchers.Default
    val scope = CoroutineScope(context)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable {
                scope.launch {
                        model2.getUrl(itemName)
                    launch (Dispatchers.Main){
                        navController.navigate("toyotaCar/$itemName")
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
fun ToyotaTopBar(navController: NavController) {
    TopAppBar(modifier = Modifier.fillMaxWidth(), backgroundColor = Color.DarkGray, contentColor = Color.White,  elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        },
        title = { Text("TOYOTA")}
    )
}


