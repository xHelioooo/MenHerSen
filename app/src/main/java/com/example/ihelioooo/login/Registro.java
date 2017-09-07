package com.example.ihelioooo.login;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre;
    EditText etusuario;
    EditText etpass;
    EditText etcorreo;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre = (EditText) findViewById(R.id.ET_Nombre);
        etusuario = (EditText) findViewById(R.id.ET_Usuario);
        etpass = (EditText) findViewById(R.id.ET_pass);
        etcorreo = (EditText) findViewById(R.id.ET_Correo);

        btnReg = (Button) findViewById(R.id.btn_Registrar);

        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final String nombre = etnombre.getText().toString();
        final String usuario = etusuario.getText().toString();
        final String pass = etpass.getText().toString();
        final String correo = etcorreo.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);

                    boolean success = jsonResponse.getBoolean("success");

                    if (success){
                        Intent intent = new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);
                    }else{

                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("ERROR DE REGISTRO QUERIDO PROFESOR DISCULPE LAS MOLESTIAS ")
                                .setNegativeButton("Retry",null)
                                .create().show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegistroRequest registerRequest = new RegistroRequest(nombre, usuario, pass, correo, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);

    }
}