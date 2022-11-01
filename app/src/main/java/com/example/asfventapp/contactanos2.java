package com.example.asfventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class contactanos2 extends AppCompatActivity {
    private Bundle bundle;
    private TextView Saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos2);

        Saludo = (TextView) findViewById(R.id.Saludo);

        bundle = getIntent().getExtras();

        String Nombre = bundle.getString("nombre");
        String Apellido = bundle.getString("apellido");
        String Fono = bundle.getString("fono");
        String Correo = bundle.getString("correo");

        Saludo.append(" " + Nombre + " " + Apellido +
                "." + "\n\nEn el siguiente recuadro ingresa tu consulta la cual " +
                "será atendida a la brevedad. \n\nRecuerda indicar si prefieres" +
                " ser contactado vía teléfono al numero " + Fono +
                " o al Correo " + Correo);
    }
}