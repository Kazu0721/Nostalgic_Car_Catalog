package com.example.nostalgiccarcatalog.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nostalgiccarcatalog.toyota.ToyotaViewModel
import com.example.nostalgiccarcatalog.makes.MakesScreen
import com.example.nostalgiccarcatalog.model.ToyotaModel
import com.example.nostalgiccarcatalog.model.ToyotaWebView
import com.example.nostalgiccarcatalog.toyota.ToyotaCarsReferenceScreen
import com.example.nostalgiccarcatalog.toyota.ToyotaScreen
import com.example.nostalgiccarcatalog.toyota.ToyotaCarsScreen

@Composable
fun Screen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MakesScreen(navController = navController)
        }
        composable("toyota",) {
            val name: String = "TOYOTA"
             val model = hiltViewModel<ToyotaViewModel>()
            ToyotaScreen(navController = navController, model=model, name)
        }

        composable("toyotaCar/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Nothing"

            ToyotaCarsScreen(navController = navController, name = ToyotaModel(name))
        }

        composable("toyotaCarsReference/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val model = hiltViewModel<ToyotaViewModel>()
            val name = backStackEntry.arguments?.getString("name") ?: ""

            ToyotaCarsReferenceScreen(navController = navController, name = ToyotaModel(name), model)
        }
        composable("webView/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""

            WebViewScreen(navController = navController,  url)
        }

    }
}