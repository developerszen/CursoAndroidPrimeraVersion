package com.zentechnology.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private val webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Pagina Web"

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
