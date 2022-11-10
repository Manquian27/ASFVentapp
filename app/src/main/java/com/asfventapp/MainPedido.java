package com.asfventapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainPedido extends AppCompatActivity {

    private EditText ed_nombre, ed_sistema;
    private Button b_agregar, b_ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        ed_nombre = findViewById(R.id.et_nombre);
        ed_sistema = findViewById(R.id.et_sistema);

        b_agregar = findViewById(R.id.btnCrear);
        b_ver = findViewById(R.id.btnLista);

        b_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
            }
        });
        b_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
    }

    public void insertar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String sistema = ed_sistema.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS pedido(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR,sistema VARCHAR)");

            String sql = "insert into pedido(nombre,sistema)values(?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,sistema);
            statement.execute();
            Toast.makeText(this,"Pedido agregado satisfactoriamente en la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_sistema.setText("");
            ed_nombre.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error! no se pudo guardar su pedido.",Toast.LENGTH_LONG).show();
        }
    }


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
                Intent intent = new Intent(MainPedido.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainPedido.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainPedido.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MainPedido.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(MainPedido.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(MainPedido.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.action_st:
                Toast.makeText(this,"Pedido juegos seleccionado", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}