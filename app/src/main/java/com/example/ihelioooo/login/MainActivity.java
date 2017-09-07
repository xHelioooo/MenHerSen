package com.example.ihelioooo.login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tvRegistrar;
    Button btnIng;
    EditText etusuario;
    EditText etpass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvRegistrar = (TextView) findViewById(R.id.textRegistrar);
        btnIng = (Button) findViewById(R.id.btn_Ingg);
        etusuario = (EditText) findViewById(R.id.TV_Usuario);
        etpass = (EditText) findViewById(R.id.TV_Contraseña);

        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegistrar = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentRegistrar);
            }
        });

        btnIng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                final String usuario = etusuario.getText().toString();
                final String pass = etpass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){

                                String nombre = jsonResponse.getString("nombre");
                                String correo = jsonResponse.getString("correo");

                                Intent intent = new Intent(MainActivity.this, Loby.class);

                                intent.putExtra("nombre", nombre);
                                intent.putExtra("usuario", usuario);
                                intent.putExtra("pass", pass);
                                intent.putExtra("correo", correo);

                                MainActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("ERROR DE LOGEO QUERIDO PROFESOR DISCULPE LAS MOLESTIAS")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest(usuario, pass, responseListener );

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

    }
}
