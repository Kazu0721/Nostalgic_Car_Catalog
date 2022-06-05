package com.example.nostalgiccarcatalog.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nostalgiccarcatalog.CarScreen
import com.example.nostalgiccarcatalog.CarsReferenceScreen
import com.example.nostalgiccarcatalog.PhotoCarsScreen
import com.example.nostalgiccarcatalog.makes.MakesScreen



@Composable
fun Screen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MakesScreen(navController = navController)
        }
        composable("{name}",
            arguments = listOf(navArgument("name"){type = NavType.StringType})
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            Log.d("NAME_NAME","$name")
            CarScreen(navController = navController,  name = name )
        }

        composable("itemsPhoto/{itemName}",
            arguments = listOf(navArgument("itemName") { type = NavType.StringType })
        ) { backStackEntry ->
            val itemName = backStackEntry.arguments?.getString("itemName") ?: ""

            PhotoCarsScreen(navController = navController, itemName = itemName)
        }

        composable("carsReference/{itemName}",
            arguments = listOf(navArgument("itemName") { type = NavType.StringType })
        ) { backStackEntry ->
            val itemName = backStackEntry.arguments?.getString("itemName") ?: ""

            CarsReferenceScreen(navController = navController, name = itemName)
        }
        composable("webView/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""

            WebViewScreen(navController = navController,  url)
        }

    }
}