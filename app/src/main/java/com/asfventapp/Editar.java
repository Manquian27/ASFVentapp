package com.asfventapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Editar extends AppCompatActivity {

    private EditText ed_nombre,ed_sistema,ed_id;
    private Button b_editar,b_eliminar,b_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pedidos);

        ed_nombre = findViewById(R.id.et_nombre);
        ed_sistema = findViewById(R.id.et_sistema);
        ed_id = findViewById(R.id.Id);

        b_editar = findViewById(R.id.btnEditar);
        b_eliminar = findViewById(R.id.btnBorrar);
        b_volver = findViewById(R.id.btnVolver);

        Intent i = getIntent();

        String Id = i.getStringExtra("id").toString();
        String et_nombre = i.getStringExtra("nombre").toString();
        String et_sistema = i.getStringExtra("sistema").toString();

        ed_id.setText(Id);
        ed_nombre.setText(et_nombre);
        ed_sistema.setText(et_sistema);

        b_editar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                editar();
            }
        });

        b_eliminar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                eliminar();
            }
        });

        b_volver.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
            }
        });
    }

    public void eliminar()
    {
        try
        {
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO", Context.MODE_PRIVATE,null);


            String sql = "delete from pedido where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Pedido borrado de la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_sistema.setText("");
            ed_nombre.requestFocus();

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error! no se pudo eliminar su pedido.",Toast.LENGTH_LONG).show();
        }
    }
    public void editar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String sistema = ed_sistema.getText().toString();
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO",Context.MODE_PRIVATE,null);

            String sql = "update pedido set nombre = ?,sistema=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,sistema);
            statement.bindString(3,id);
            statement.execute();
            Toast.makeText(this,"Pedido actualizado satisfactoriamente en la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_sistema.setText("");
            ed_nombre.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error! no se pudo actualizar el pedido.",Toast.LENGTH_LONG).show();
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
                Intent intent = new Intent(Editar.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Editar.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Editar.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Editar.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(Editar.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(Editar.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.action_st:
                Toast.makeText(this,"Pedido juegos seleccionado", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(Editar.this, MainPedido.class);
                startActivity(intent7);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
