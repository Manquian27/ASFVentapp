package com.asfventapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Leer extends AppCompatActivity {

    private ListView lst1;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        try{
            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO", Context.MODE_PRIVATE,null);
            lst1 = findViewById(R.id.ListaPedidos);
            final Cursor c = db.rawQuery("select * from pedido",null);
            int id = c.getColumnIndex("id");
            int nombre = c.getColumnIndex("nombre");
            int sistema = c.getColumnIndex("sistema");
            arreglo.clear();

            arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arreglo);

            lst1.setAdapter(arrayAdapter);

            final  ArrayList<Pedido> lista = new ArrayList<Pedido>();


            if(c.moveToFirst())
            {
                do{
                    Pedido pedido = new Pedido();
                    pedido.id = c.getString(id);
                    pedido.nombre = c.getString(nombre);
                    pedido.sistema = c.getString(sistema);
                    lista.add(pedido);

                    arreglo.add(c.getString(id) + " \t " + c.getString(nombre) + " \t "  + c.getString(sistema) );

                } while(c.moveToNext());
                arrayAdapter.notifyDataSetChanged();
                lst1.invalidateViews();
            }

            lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, android.view.View view, int position, long l) {
                    Pedido pedido = lista.get(position);
                    Intent i = new Intent(getApplicationContext(), Editar.class);
                    i.putExtra("id",pedido.id);
                    i.putExtra("nombre",pedido.nombre);
                    i.putExtra("sistema",pedido.sistema);
                    startActivity(i);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(this, "Ha ocurrido un error, intentalo nuevamente.", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(Leer.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Leer.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Leer.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Leer.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(Leer.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.action_visitanos:
                Toast.makeText(this,"Visitanos", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(Leer.this, MapActivity.class);
                startActivity(intent6);
                finish();
                break;
            case R.id.action_st:
                Toast.makeText(this,"Pedido juegos seleccionado", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(Leer.this, MainPedido.class);
                startActivity(intent7);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}