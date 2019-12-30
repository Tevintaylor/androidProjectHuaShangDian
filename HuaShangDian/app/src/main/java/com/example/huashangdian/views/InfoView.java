package com.example.huashangdian.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.huashangdian.R;

public class InfoView extends AppCompatActivity {

    ImageView tevinFace;
    ImageView tevinInsa;
    ImageView tevinGit;

    ImageView donteFace;
    ImageView donteInsa;
    ImageView donteGit;

    private WebView webView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);

        //        url buttons

        tevinFace = findViewById(R.id.tevinFacbook);
        tevinInsa = findViewById(R.id.tevinInsta);
        tevinGit = findViewById(R.id.tevinGit);

        donteFace = findViewById(R.id.donteFacebook);
        donteInsa = findViewById(R.id.donteInsta);
        donteGit = findViewById(R.id.donteGit);

        webView = findViewById(R.id.webView);

        tevinFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tevin  FaceBook", Toast.LENGTH_LONG).show();
                OpenWebViewFacebook();
            }
        });

        tevinInsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tevin  Instagram", Toast.LENGTH_LONG).show();
                OpenWebViewInstgram();
            }
        });

        tevinGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tevin  GitHub", Toast.LENGTH_LONG).show();
                OpenWebViewGit();

            }
        });

        donteFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Donte  FaceBook", Toast.LENGTH_LONG).show();
            }
        });

        donteInsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Donte  Instagram", Toast.LENGTH_LONG).show();
            }
        });

        donteGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Donte  GitHub", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void OpenWebViewFacebook() {
        Intent intent = new Intent(this, WebViewClass.class);
        intent.putExtra("url","https://www.facebook.com/profile.php?id=100005822538985" ); //Your id
        startActivity(intent);
    }

    public void OpenWebViewInstgram() {
        Intent intent = new Intent(this, WebViewClass.class);
        intent.putExtra("url", "https://www.instagram.com/tong.weiii/"); //Your id
        startActivity(intent);
    }
    public void OpenWebViewGit() {
        Intent intent = new Intent(this, WebViewClass.class);
        intent.putExtra("url", "https://github.com/Tevintaylor"); //Your id
        startActivity(intent);
    }
}
