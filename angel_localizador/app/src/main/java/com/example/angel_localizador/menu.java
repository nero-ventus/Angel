package com.example.angel_localizador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    Button LE,LI,PP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        LE=findViewById(R.id.localizacion_externa);
        LE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiador = new Intent(getApplicationContext(), mapa.class);
                startActivity(cambiador);
            }
        });
        LI=findViewById(R.id.localizacion_interna);
        LI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiador = new Intent(getApplicationContext(), localizacion_interna.class);
                startActivity(cambiador);
            }
        });
        PP=findViewById(R.id.pagina_princi);
        PP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiador = new Intent(getApplicationContext(), wview.class);
                startActivity(cambiador);
            }
        });
    }
}
