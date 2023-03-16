package com.ifsc.meuapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment;
    Button botaoA, botaoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoA = findViewById(R.id.btn1);
        botaoB = findViewById(R.id.btn2);
        botaoA.setOnClickListener(this);
        botaoB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                fragment = new fragment_a();
                break;

            case R.id.btn2:
                fragment = new fragment_b();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framemain, fragment);
        transaction.commit();
    }
}