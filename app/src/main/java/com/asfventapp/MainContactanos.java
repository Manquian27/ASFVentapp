package com.asfventapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainContactanos extends AppCompatActivity {
    private EditText editTxtNombre;
    private EditText edTxtFono;
    private EditText edTxtCorreo;
    private EditText editTxtApellido;
    private Button btnEnviar;

    @Override
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
                Intent intent = new Intent(MainContactanos.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainContactanos.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainContactanos.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MainContactanos.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(MainContactanos.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.action_st:
                Toast.makeText(this,"Pedido juegos seleccionado", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(MainContactanos.this, MainPedido.class);
                startActivity(intent7);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        editTxtNombre = (EditText) findViewById(R.id.editTxtNombre);
        edTxtFono = (EditText) findViewById(R.id.edTxtFono);
        edTxtCorreo = (EditText) findViewById(R.id.edTxtCorreo);
        editTxtApellido = (EditText) findViewById(R.id.editTxtApellido);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTxtNombre.getText().toString().isEmpty() && !edTxtFono.getText().toString().isEmpty() && !edTxtCorreo.getText().toString().isEmpty() && !editTxtApellido.getText().toString().isEmpty()){
                    Intent intent = new Intent(MainContactanos.this, contactanos2.class);
                    intent.putExtra("nombre", editTxtNombre.getText().toString());
                    intent.putExtra("apellido", editTxtApellido.getText().toString());
                    intent.putExtra("fono", edTxtFono.getText().toString());
                    intent.putExtra("correo", edTxtCorreo.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainContactanos.this, "Por favor, complete todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}