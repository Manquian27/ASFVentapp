package com.example.asfventapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
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