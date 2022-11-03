package com.example.asfventapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CabinetActivity extends AppCompatActivity {

    Spinner mem_arcade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);
        mem_arcade = findViewById(R.id.idSpinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.memoria_cabinet, android.R.layout.simple_spinner_item);

        mem_arcade.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_main:
                Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CabinetActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(CabinetActivity.this, ConsolaActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(CabinetActivity.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(CabinetActivity.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(CabinetActivity.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}