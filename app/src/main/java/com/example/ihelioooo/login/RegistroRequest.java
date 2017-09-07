package com.example.ihelioooo.login;

import android.net.sip.SipAudioCall;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iHelioooo on 23-08-2017.
 */

public class RegistroRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://192.168.42.166/Register.php";
    private Map<String,String> params;
    public RegistroRequest(String nombre, String usuario, String pass , String correo, Response.Listener<String> Listener){
        super(Method.POST, REGISTER_REQUEST_URL, Listener, null);
        params = new HashMap<>();
        params.put("nombre",nombre);
        params.put("usuario",usuario);
        params.put("pass",pass);
        params.put("correo",correo);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
