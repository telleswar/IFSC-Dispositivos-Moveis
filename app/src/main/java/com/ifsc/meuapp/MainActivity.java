package com.ifsc.meuapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment fragmentA, fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTela(View v){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    public void abreFragmentA(View v){
        fragmentA = new fragment_a();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framemain, fragmentA);
        transaction.commit();
    }

    public void abreFragmentB(View v){
        fragmentB = new fragment_b();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framemain, fragmentB);
        transaction.commit();
    }
}