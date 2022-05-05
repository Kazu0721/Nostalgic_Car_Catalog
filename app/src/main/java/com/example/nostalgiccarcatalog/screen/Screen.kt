package com.example.nostalgiccarcatalog.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nostalgiccarcatalog.makes.MakesScreen
import com.example.nostalgiccarcatalog.toyota.ToyotaCarsScreen
import com.example.nostalgiccarcatalog.toyota.ToyotaModel
import com.example.nostalgiccarcatalog.toyota.ToyotaScreen

@Composable
fun Screen(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MakesScreen(navController = navController)
        }
        composable("toyota") {
            ToyotaScreen(navController = navController)
        }

        composable("toyotaCar/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: 0

            ToyotaCarsScreen(navController = navController, name = ToyotaModel(name as String))
        }
    }
}