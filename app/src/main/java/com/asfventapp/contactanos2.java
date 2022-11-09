package com.asfventapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


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
    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_main:
                Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(contactanos2.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(contactanos2.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(contactanos2.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(contactanos2.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(contactanos2.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(contactanos2.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}