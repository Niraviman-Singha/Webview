package com.example.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var webview: WebView
    private lateinit var btnGo: Button
    private lateinit var btnGoBack: Button
    private lateinit var btnGoForword: Button
    private lateinit var edtUrl: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview = findViewById(R.id.webview)
        btnGo = findViewById(R.id.btnGo)
        btnGoBack = findViewById(R.id.btnGoBack)
        btnGoForword = findViewById(R.id.btnGoForword)
        edtUrl = findViewById(R.id.edtUrl)

        val context = this

        webview.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener({
            webview.loadUrl("https://" + edtUrl.toString())
        })

        btnGoBack.setOnClickListener({
            if (webview.canGoBack()) {
                webview.goBack()
                edtUrl.setText(webview.url)
            } else {

            }
        })

        btnGoForword.setOnClickListener({
            if (webview.canGoForward()) {
                webview.goForward()
                edtUrl.setText(webview.url)
            } else {

            }
        })


    }
        @Suppress("OverridingDeprecatedMember")
    class MyWebViewClient : WebViewClient() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url!!)
            return true
        }

    }


}