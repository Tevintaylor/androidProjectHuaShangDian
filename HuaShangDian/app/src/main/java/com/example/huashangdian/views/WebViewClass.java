package com.example.huashangdian.views;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.huashangdian.R;

public class WebViewClass extends AppCompatActivity {

    private WebView webView2;
    private String st;
    private String value;

    //   public WebViewClass{
    //
    //    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);


        value = getIntent().getExtras().getString("url");
        System.out.println(value);

        webView2 = findViewById(R.id.webView2);
        webView2.setWebViewClient(new WebViewClient());

        webView2.loadUrl(value);

    }
}