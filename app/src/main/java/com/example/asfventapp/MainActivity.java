package com.example.asfventapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.RecyclerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this,1));
        listDatos=new ArrayList<String>();

        for (int i=1;i<=10;i++){
            listDatos.add("Noticia # "+i+"\n \nLorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Fusce a mi purus. Nullam id faucibus purus. Sed facilisis arcu enim, at ornare dolor" +
                    " ultricies quis. Sed dolor nibh, elementum eu lacus in, mattis consectetur neque. Donec" +
                    " sed lectus nisi. Maecenas bibendum risus finibus rhoncus scelerisque.\n \n \n");
        }

        CourseAdapter adapter1=new CourseAdapter(listDatos);

        recycler.setAdapter(adapter1);
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
                break;
            case R.id.action_cabinet:
                Toast.makeText(this,"Arcade Cabinet", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, CabinetActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.action_consola:
                Toast.makeText(this,"Consola Arcade", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainActivity.this, ConsolaActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.action_perfil:
                Toast.makeText(this,"Ingresar a tu cuenta", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent4);
                finish();
                break;
            case R.id.action_contactanos:
                Toast.makeText(this,"Contactanos", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(MainActivity.this, MainContactanos.class);
                startActivity(intent5);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

}