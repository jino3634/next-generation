package com.example.jangdaeyoung.loginapplication3;

import android.support.annotation.StringRes;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.net.ResponseCache;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
<<<<<<< HEAD
<<<<<<< HEAD
    final static private String URL = "http:/192.168.255.187//login_android.php";
=======
    final static private String URL = "http://172.30.83.127/login_android.php";
>>>>>>> 99b7daf9b4b817ab1b2a222e9065f2acc0d9c585
=======
    final static private String URL = "http://172.30.83.127/login_android.php";
>>>>>>> origin/jang
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
