package com.example.ihelioooo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {
    TextView tvNombre, tvUsuario, tvPass, tvCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        tvNombre = (TextView) findViewById(R.id.Text_V_Nombre);
        tvUsuario = (TextView) findViewById(R.id.Text_V_Usuario);
        tvPass = (TextView) findViewById(R.id.Text_V_Contrasña);
        tvCorreo = (TextView) findViewById(R.id.Text_V_Correo);


        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String usuario = intent.getStringExtra("usuario");
        String pass = intent.getStringExtra("pass");
        String correo = intent.getStringExtra("correo");

        tvNombre.setText(nombre);
        tvUsuario.setText(usuario);
        tvPass.setText(pass);
        tvCorreo.setText(correo);


    }
}
