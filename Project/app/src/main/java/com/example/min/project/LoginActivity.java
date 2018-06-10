package com.example.min.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private AlertDialog dialog;
    EditText idText,passwordText;
    Button loginButton;
    String json;

    Runnable r = new Runnable() {
        @Override
        public void run() {
            sendMessage(1);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread th = new Thread(r);
                th.start();
                try {
                    //readlog task = new readlog();
                    //task.execute("http://wshwan15.cafe24.com/readlog.php");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "hh", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    //유저정보 읽기
    private class readlog extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(getApplicationContext(),"first", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            json = result;
            logresult();
        }


        @Override
        protected String doInBackground(String... params) {
            try {
            Toast.makeText(getApplicationContext(),"second", Toast.LENGTH_SHORT).show();
            String serverURL = params[0];

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); //오픈커넥터


                httpURLConnection.setReadTimeout(5000); //읽기타임아웃
                httpURLConnection.setConnectTimeout(5000); //연결타임아웃
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                //Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream; //1바이트씩 읽어오는
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8"); // utf-8 문자집합의 인풋스트림리더
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //인풋스트림리더로부터 라인단위로 데이터를 읽음

                StringBuilder sb = new StringBuilder(); //변할 수 있음
                String line; //값이 변하지 않음 // 값이 바뀔때마다 메모리를 다시 할당함

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                //Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();
                //Toast.makeText(getContext(),"error4", Toast.LENGTH_SHORT).show();
                return null;
            }

        }
    }

    private void logresult() {
        Toast.makeText(getApplicationContext(),"Third", Toast.LENGTH_SHORT).show();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("webnautes");


            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);
                String suc = item.getString("success");
                String id = item.getString("id");

            }
            Toast.makeText(getApplicationContext(),"suc",Toast.LENGTH_LONG).show();



        } catch (JSONException e) {

            //Toast.makeText(getContext(),"error2", Toast.LENGTH_SHORT).show();

        }

    }

}


