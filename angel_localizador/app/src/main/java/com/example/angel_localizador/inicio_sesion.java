package com.example.angel_localizador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class inicio_sesion extends AppCompatActivity {

    TextView Correo,Contra;
    Button Acceder;
    int respuesta_acceso=0;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String correo_ob=preferencias.getString("correo",null);
        String contra_ob=preferencias.getString("contra",null);
        setContentView(R.layout.activity_inicio_sesion);
        if(correo_ob==null && contra_ob==null) {
            Correo = findViewById(R.id.correo_inicio);
            Contra = findViewById(R.id.contra_inicio);
            Acceder = findViewById(R.id.acceder_inicio);
            Acceder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String URL_Acceso = "http://192.168.42.28:8080/Angel/rest/iniciar/" + Correo.getText().toString() + "/" + Contra.getText().toString();
                    RequestQueue rq = Volley.newRequestQueue(v.getContext());
                    JsonObjectRequest objecto_r = new JsonObjectRequest(
                            Request.Method.GET,
                            URL_Acceso,
                            null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        respuesta_acceso = response.getInt("acceso");
                                        if (respuesta_acceso == 1) {
                                            preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                            SharedPreferences.Editor edita = preferencias.edit();
                                            edita.putString("correo", Correo.getText().toString());
                                            edita.putString("contra", Contra.getText().toString());
                                            edita.commit();
                                            Intent cambiador = new Intent(getApplicationContext(), menu.class);
                                            startActivity(cambiador);
                                            respuesta_acceso = 0;
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    error.printStackTrace();
                                    Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                                }
                            }
                    );
                    rq.add(objecto_r);
                }
            });
        }
        else{
            Intent cambiador = new Intent(getApplicationContext(), menu.class);
            startActivity(cambiador);
        }
    }
}