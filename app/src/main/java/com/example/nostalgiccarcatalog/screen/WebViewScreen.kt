package com.example.nostalgiccarcatalog.screen

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.nostalgiccarcatalog.model.ToyotaWebView
import java.net.URL

@Composable
fun WebViewScreen(navController: NavController, url: String){
    AndroidView(
        factory = ::WebView,
        update = { webView ->
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
        }
    )

}

