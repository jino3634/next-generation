package com.example.jangdaeyoung.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity
{
    Button btn_Start;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Start = (Button)findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 로그인 성공
                //화면을 전환할때 사용하는 클래스
                Intent intent =
                        new Intent(
                                LoginActivity.this,MainActivity.class);
                //화면 전환하기
                startActivity(intent);
            }
        } );
    }
}
