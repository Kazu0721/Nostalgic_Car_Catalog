package com.example.nostalgiccarcatalog.makes

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nostalgiccarcatalog.R

@Composable
fun MakesScreen(navController: NavController) {

    Scaffold(topBar = {MainTopBar()}) {
        Box(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize())
        {
            Column(modifier = Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceEvenly ){
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.bmw),  contentDescription ="bmw" )
                    }
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                            Image(painter = painterResource(id = R.drawable.lamborghini), contentDescription ="Lamborgini")
                        }
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Box(modifier = Modifier
                        .clickable(onClick = { navController.navigate("toyota") })
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                            Image(painter = painterResource(id = R.drawable.toyota),  contentDescription ="Toyota" )

                    }
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.porsche),  contentDescription ="porsche" )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.ferrari),  contentDescription ="Ferrari" )
                    }
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.ford),  contentDescription ="Ford" )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.astonmartin),  contentDescription ="AstonMartin" )
                    }
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.lancia),  contentDescription ="Lancia" )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.chevrolet),  contentDescription ="Chevrolet" )
                    }
                    Box(modifier = Modifier
                        .clickable(onClick = {})
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(15))) {
                        Image(painter = painterResource(id = R.drawable.lotus),  contentDescription ="Lotus" )
                    }
                }
            }
        }
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
