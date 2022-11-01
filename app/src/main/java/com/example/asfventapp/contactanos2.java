package com.example.asfventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class contactanos2 extends AppCompatActivity {
    private Bundle bundle;
    private TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos2);

        tvSaludo = (TextView) findViewById(R.id.tvSaludo);

        bundle = getIntent().getExtras();

        String saludo = bundle.getString("nombre");

        tvSaludo.append(" " + saludo + " :D");
    }
}