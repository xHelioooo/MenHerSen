package com.example.ihelioooo.login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iHelioooo on 23-08-2017.
 */

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="http://192.168.42.166/Login.php";
    private Map<String,String> params;
    public LoginRequest(String usuario, String pass ,Response.Listener<String> Listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, Listener, null);
        params = new HashMap<>();
        params.put("usuario",usuario);
        params.put("pass",pass);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
