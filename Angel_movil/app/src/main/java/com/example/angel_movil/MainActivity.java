package com.example.angel_movil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //Comment code later
    WebView wview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wview=findViewById(R.id.webview1);
        wview.setWebViewClient(new WebViewClient());
        wview.getSettings().setJavaScriptEnabled(true);
        wview.getSettings().setBuiltInZoomControls(true);
        wview.getSettings().setDisplayZoomControls(false);
        wview.getSettings().setDomStorageEnabled(true);
        wview.loadUrl("http://192.168.42.28:8080/Angel/AngelLogIn.html");
        /*Direc en escuela: http://192.168.43.143:8080/Angel/AngelLogInTodos.html*/
        /*Direc en casa: http://192.168.100.10:8080/Angel/AngelLogInTodos.html*/
    }

    @Override
    public void onBackPressed() {
        if(wview.canGoBack()){
            wview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
