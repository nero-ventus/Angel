package com.example.angel_localizador;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener{

    LocationManager manejador;
    TextView mostrador;
    Button boton_mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrador = findViewById(R.id.coordenadas);
        boton_mapa=findViewById(R.id.boton);
        boton_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiador=new Intent(v.getContext(), mapa.class);
                startActivity(cambiador);
            }
        });
        System.out.println("Llego aqui");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
        }
        else{
            manejador = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            manejador.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            manejador.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode==0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                manejador = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                manejador.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
                manejador.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mostrador.setText("Latitud: "+location.getLatitude()+" Longitud: "+location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        System.out.println("Estado Cambiado");
        System.out.println(status);
    }

    @Override
    public void onProviderEnabled(String provider) {
        System.out.println("Provedor activado: "+provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        System.out.println("Provedor desactivado:"+provider);
    }
}