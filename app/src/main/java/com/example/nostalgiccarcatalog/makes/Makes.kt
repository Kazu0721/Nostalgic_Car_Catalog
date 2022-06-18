package com.example.nostalgiccarcatalog.makes

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.R

@Composable
fun MakesScreen(navController: NavController) {

    Scaffold(topBar = {MainTopBar()}) {
        Box(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize())
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row{
                    CarComposable(resourceId =  R.drawable.bmw, text = "BMW", navController, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp))
                    CarComposable(resourceId =  R.drawable.lotus, text = "LOTUS", navController, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp))
                }
                Row{
                    CarComposable(resourceId =  R.drawable.toyota, text = "TOYOTA", navController, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp))
                    CarComposable(resourceId =  R.drawable.detomaso, text = "DE TOMASO", navController, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp))
                }
            }
        }
    }
}

@Composable
fun CarComposable(resourceId: Int, text: String, navController: NavController, modifier: Modifier) {
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(modifier = Modifier
            .clickable(onClick = { navController.navigate("$text")})
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(15)))
        {
            Image(painter = painterResource(id = resourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)
        }
        Text(text = text, color = Color.White,)
    }
}

@Composable
fun MainTopBar() {
    TopAppBar( modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        title = { Text(stringResource(id = R.string.app_name))},
        elevation = 0.dp

   )
}
