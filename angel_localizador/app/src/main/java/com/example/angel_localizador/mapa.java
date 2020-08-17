package com.example.angel_localizador;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.angel.modelos.dispositivo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.maps.android.SphericalUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class mapa extends FragmentActivity implements OnMapReadyCallback, LocationListener{

    private GoogleMap mMap;
    LocationManager manejador;
    SharedPreferences preferencias;
    ArrayList<dispositivo> lista_dispositivos=new ArrayList<dispositivo>();
    Marker pos_actual,posn1,posn2;
    LatLng tu_posicion;
    int distancia_permitida=3;
    Timer timert1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
        }
        else{
            manejador = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            manejador.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            manejador.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String URL_Obtener_config="http://192.168.42.28:8080/Angel/rest/configex/"+preferencias.getString("correo",null);
        RequestQueue rq1= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest objecto_r1=new JsonObjectRequest(
                Request.Method.GET,
                URL_Obtener_config,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            System.out.println("Distancia set up");
                            distancia_permitida=response.getInt("distancia_permitida");
                        }
                        catch(Exception e){
                            distancia_permitida=3;
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        distancia_permitida=3;
                    }
                }
        );
        rq1.add(objecto_r1);
        mMap = googleMap;
        tu_posicion = new LatLng(19.453640, -99.175707);
        pos_actual= mMap.addMarker(new MarkerOptions().position(tu_posicion).title("Posicion actual"));
        mMap.addCircle(new CircleOptions().center(tu_posicion).radius(distancia_permitida).fillColor(Color.parseColor("#dce6f7")).strokeColor(Color.parseColor("#8db6fc")));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tu_posicion, 19.0f));
        posn1= mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Posicion dispositivo: 1"));
        posn2= mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Posicion dispositivo: 2"));
        timert1=new Timer();
        timert1.schedule(new TimerTask() {
            @Override
            public void run() {
                preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String URL_Obtener="http://192.168.42.28:8080/Angel/rest/dispo/"+preferencias.getString("correo",null);
                RequestQueue rq= Volley.newRequestQueue(getApplicationContext());
                JsonArrayRequest objecto_r=new JsonArrayRequest(
                        URL_Obtener,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try{
                                    lista_dispositivos=new ArrayList<dispositivo>();
                                    System.out.println(response.getJSONObject(0).getString("posicion_global"));
                                    for(int i=0;i<response.length();i++){
                                        lista_dispositivos.add(new dispositivo(response.getJSONObject(i).getString("id_dispositivo"),response.getJSONObject(i).getString("posicion_global"),response.getJSONObject(i).getString("codigo")));
                                    }

                                    int tamano=lista_dispositivos.size();
                                    String lat="",lon="";
                                    if(tamano>0){
                                        for(int i=0;i<lista_dispositivos.size();i++){
                                            int lat_o_long=0;
                                            for(int j=0;j<lista_dispositivos.get(i).getPosicion_global().length();j++){
                                                if(lista_dispositivos.get(i).getPosicion_global().charAt(j)==','){
                                                    lat_o_long=1;
                                                }
                                                else{
                                                    if(lat_o_long==0){
                                                        lat+=lista_dispositivos.get(i).getPosicion_global().charAt(j);
                                                    }
                                                    else{
                                                        lon+=lista_dispositivos.get(i).getPosicion_global().charAt(j);
                                                    }
                                                }
                                            }

                                            LatLng posicion_child=new LatLng(Double.parseDouble(lat),Double.parseDouble(lon));

                                            if(i==0){
                                                posn1.setPosition(posicion_child);
                                            }
                                            if(i==1){
                                                posn2.setPosition(posicion_child);
                                            }
                                            int distancia=(int)SphericalUtil.computeDistanceBetween(tu_posicion,posicion_child);

                                            if(distancia>distancia_permitida){
                                                NotificationCompat.Builder constructor_notificacion=new NotificationCompat.Builder(getApplicationContext());
                                                constructor_notificacion.setContentTitle("Alerta");
                                                constructor_notificacion.setSmallIcon(R.drawable.icono);
                                                constructor_notificacion.setContentText("Dispositivo:"+lista_dispositivos.get(i).getId_dispositivo()+" fuera de rango");
                                                constructor_notificacion.setSound(RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(),RingtoneManager.TYPE_NOTIFICATION));

                                                Intent notificationIntent = new Intent(getApplicationContext(), mapa.class);
                                                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                                                constructor_notificacion.setContentIntent(contentIntent);
                                                constructor_notificacion.setAutoCancel(true);
                                                constructor_notificacion.setLights(Color.BLUE, 500, 500);
                                                long[] pattern = {500,500,500,500,500,500,500,500,500};
                                                constructor_notificacion.setVibrate(pattern);
                                                constructor_notificacion.setStyle(new NotificationCompat.InboxStyle());
                                                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                                manager.notify(1, constructor_notificacion.build());
                                            }
                                        }
                                    }
                                }
                                catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        }
                );
                rq.add(objecto_r);
            }
        },0,5000);
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
        /*tu_posicion = new LatLng(location.getLatitude(), location.getLongitude());
        pos_actual.setPosition(tu_posicion);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 18.0f));*/
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
