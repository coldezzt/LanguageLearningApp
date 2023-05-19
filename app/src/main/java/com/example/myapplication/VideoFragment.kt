package com.example.myapplication

import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VideoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        val videoPage = view.findViewById<WebView>(R.id.videoView)
        videoPage.settings.javaScriptEnabled = true
        videoPage.webViewClient = WebViewClient()

        videoPage.loadUrl("https://www.youtube.com/")
        return view
    }
}