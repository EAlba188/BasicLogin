package com.example.examenpilar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    protected Button cerrarSesion;
    protected TextView sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        init();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        sesion = findViewById(R.id.tvWelcome);
        sesion.setText("Bienvenido ");
        sesion.append(extras.getString("nombre"));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cerrarSesion = findViewById(R.id.btCerrar);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }












}