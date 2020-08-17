package com.example.angel_localizador;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.angel.modelos.dispositivo;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class localizacion_interna extends AppCompatActivity {

    TextView texto;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion_interna);
        texto=findViewById(R.id.localiza_texto_interna);
        preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Timer timer1=new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                String URL_Verificar="http://192.168.42.28:8080/Angel/rest/configin/"+preferencias.getString("correo",null);
                RequestQueue rq= Volley.newRequestQueue(getApplicationContext());
                JsonArrayRequest objecto_r=new JsonArrayRequest(
                    URL_Verificar,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try{
                                int pasos=0;
                                for(int i=0;i<response.length();i++){
                                    int estado=response.getJSONObject(i).getInt("estado");
                                    String id_sensor=response.getJSONObject(i).getString("id_sensor");
                                    int id_cuarto=response.getJSONObject(i).getInt("id_cuarto");
                                    int permitido=response.getJSONObject(i).getInt("estado_permiso");
                                    if(estado==2){
                                        if(permitido==2){
                                            NotificationCompat.Builder constructor_notificacion=new NotificationCompat.Builder(getApplicationContext());
                                            constructor_notificacion.setContentTitle("Movimiento en hogar detectado");
                                            constructor_notificacion.setSmallIcon(R.drawable.icono);
                                            String cuarto="";
                                            if(id_cuarto==1){
                                                cuarto="Dormitorio";
                                            }
                                            if(id_cuarto==2){
                                                cuarto="Estudio";
                                            }
                                            if(id_cuarto==3){
                                                cuarto="Baño";
                                            }
                                            if(id_cuarto==4){
                                                cuarto="Cocina";
                                            }
                                            if(id_cuarto==5){
                                                cuarto="Cuarto de Lavado";
                                            }
                                            if(id_cuarto==6){
                                                cuarto="Comedor";
                                            }
                                            if(id_cuarto==7){
                                                cuarto="Sala";
                                            }

                                            constructor_notificacion.setContentText("ID sensor: "+id_sensor+" Cuarto: "+cuarto+" fue activado");

                                            constructor_notificacion.setSound(RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(),RingtoneManager.TYPE_NOTIFICATION));

                                            Intent notificationIntent = new Intent(getApplicationContext(), localizacion_interna.class);
                                            PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                                            constructor_notificacion.setContentIntent(contentIntent);
                                            constructor_notificacion.setAutoCancel(true);
                                            constructor_notificacion.setLights(Color.BLUE, 500, 500);
                                            long[] pattern = {500,500,500,500,500,500,500,500,500};
                                            constructor_notificacion.setVibrate(pattern);
                                            constructor_notificacion.setStyle(new NotificationCompat.InboxStyle());
                                            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                            manager.notify(2, constructor_notificacion.build());

                                            texto.setText("ID sensor: "+id_sensor+" Cuarto: "+cuarto+" se detecto movimiento");
                                        }
                                    }
                                    else{
                                        pasos++;
                                    }
                                }
                                if(pasos==response.length()){
                                    texto.setText("Sin movimietno detectado");
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
}
