package com.example.examenpilar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    protected TextInputEditText email;
    protected TextInputEditText pass;
    protected Button conectar;
    protected Button registrarse;
    protected static ListaUsuarios lista = new ListaUsuarios("lista");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }


    private void init() {

        lista.añadirUsuario("admin@admin.com","edenalba", "Eden Alba");

        email = findViewById(R.id.inputEmail);
        pass = findViewById(R.id.inputPass);
        conectar = findViewById(R.id.btConectar);
        registrarse = findViewById(R.id.btRegistrar);

        conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conectar(pass.getText().toString(),email.getText().toString(), lista);
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarse();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public void conectar(String pass, String email, ListaUsuarios lista){
        boolean existe = lista.existeUsuario(email,pass);

        if(existe){
            Intent intent = new Intent(this, Inicio.class);
            intent.putExtra("nombre", lista.getNombreFind(email));
            startActivity(intent);
        }else{
            registrarse();
            Toast.makeText(this, " Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }

    }

    public void registrarse(){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this,"Una app de 10!!!", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}