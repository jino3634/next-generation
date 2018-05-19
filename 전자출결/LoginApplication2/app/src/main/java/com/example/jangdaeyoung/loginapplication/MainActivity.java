package com.example.jangdaeyoung.loginapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn_prev;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button noticeButton = (Button) findViewById(R.id.notice);
        final Button rollcallButton = (Button) findViewById(R.id.rollcallbutton);
        final Button applicationlistButton = (Button) findViewById(R.id.applicationlistbutton);
        final Button nfcrollButton = (Button) findViewById(R.id.nfcrollbutton);



        noticeButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                rollcallButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                applicationlistButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                nfcrollButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new NoticeFragment());
                fragmentTransaction.commit();
            }
        });

        rollcallButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rollcallButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                applicationlistButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                nfcrollButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new RollcallFragment());
                fragmentTransaction.commit();
            }
        });


        applicationlistButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rollcallButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                applicationlistButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                nfcrollButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ApplicationlistFragment());
                fragmentTransaction.commit();
            }
        });

        nfcrollButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                noticeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                rollcallButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                applicationlistButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                nfcrollButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new NFCrollFragment());
                fragmentTransaction.commit();
            }
        });
        btn_prev = (Button) findViewById(R.id.btn_prev);
        btn_prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //이전 화면 돌아가기
                Intent intent = new Intent(
                        MainActivity.this,LoginActivity.class);

                startActivity(intent);
            }
        });
    }
}
