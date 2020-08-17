package com.example.angel_localizador;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class wview extends AppCompatActivity {

    WebView wview;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wview);
        preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        wview=findViewById(R.id.webview1);
        wview.setWebViewClient(new WebViewClient());
        wview.getSettings().setJavaScriptEnabled(true);
        wview.getSettings().setBuiltInZoomControls(true);
        wview.getSettings().setDisplayZoomControls(false);
        wview.getSettings().setDomStorageEnabled(true);
        wview.setWebChromeClient(new WebChromeClient());
        wview.loadUrl("http://192.168.42.28:8080/Angel/seguridad_inicio_sesion?correo="+preferencias.getString("correo",null)+"&contra="+preferencias.getString("contra",null));
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
