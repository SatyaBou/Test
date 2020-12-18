package com.example.testproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AbaActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aba);
        WebView browser = findViewById(R.id.webview);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("https://test.hlhmarketplace.com/zoho/aba/popup?hash=PvpiiDfy0RzucCLRPIfTB%2BfzUyP4rZj3ziw90tc6j2p09Ymn4oIjCtBfh1%2FHv4PiTTnnBjJswl2bYZuNwHwF%2Fw%3D%3D&payment_method=abapay&trans_id=12437-1608119597&amount=4.99&firstname=Coach&lastname=New%20York&email=coachkampuchea@gmail.com&phone=010828468&items=W3sibmFtZSI6Ik1heXVyYSBULVNoaXJ0IiwicXVhbnRpdHkiOjEsInByaWNlIjo0Ljk5fV0%3D&shipping=0");
        browser.setWebViewClient(new WebViewClient());
        browser.evaluateJavascript("(function() { return document.querySelector('body').innerHTML; })();", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Log.d("responseData", "onReceiveValue: " + value);
            }
        });


    }


}

