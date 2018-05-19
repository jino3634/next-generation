package com.example.min.project;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    final static private String URL = "http://127.0.0.1/login_android.php";
    private Map<String, String> parameters;

    public LoginRequest(String id, String pw, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id",id);
        parameters.put("pw",pw);
    }
    @Override
    public Map<String, String> getParams() {return parameters;}
}
