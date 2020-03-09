package com.example.newsapp.features.newsDetails.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.newsapp.R

class NewsDetailsActivity : AppCompatActivity() {
    private var myWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        myWebView = findViewById<View>(R.id.newsWebView) as WebView

        val bundle: Bundle? = intent.extras
        loadContent(bundle)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadContent(bundle: Bundle?) {
        bundle?.let {
            if (bundle.containsKey(URL)) {
                val url = bundle.getString(URL)
                myWebView?.let {
                    it.loadUrl(url)
                    // Enable Javascript
                    val webSettings: WebSettings = it.settings
                    webSettings.javaScriptEnabled = true
                    // Force links and redirects to open in the WebView instead of in a browser
                    it.webViewClient = WebViewClient()
                    it.loadUrl(url)
                }
            }
        }
    }

    companion object {
        const val URL = "url"
    }
}