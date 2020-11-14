package com.example.examenpilar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import static com.example.examenpilar.MainActivity.lista;

public class Registro extends AppCompatActivity {
    protected TextInputEditText email;
    protected TextInputEditText pass;
    protected TextInputEditText pass2;
    protected Button registrar;
    protected TextInputEditText nombre;
    protected ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        init();
    }

    private void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imagen = findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.logo);

        nombre = findViewById(R.id.registroNombre);
        email = findViewById(R.id.registroEmail);
        pass = findViewById(R.id.registroPass);
        pass2 = findViewById(R.id.registroPass2);
        registrar = findViewById(R.id.btRegistrarReg);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentarRegistro(email.getText().toString(), pass.getText().toString(),pass2.getText().toString(), lista, nombre.getText().toString());
            }
        });


    }

    public void intentarRegistro(String email, String pass, String pass2, ListaUsuarios lista, String nombre){

        if(lista.existeUsuario(email, pass)){
            Toast.makeText(Registro.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
        }else if(!pass.equalsIgnoreCase(pass2)){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }else{
            int error = lista.añadirUsuario(email,pass,nombre);
            switch (error){
                case 1:
                    Toast.makeText(this, "Registro completado!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registro.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case 0:
                    Toast.makeText(Registro.this, "La contraseña debe tener al menos 7 digitos", Toast.LENGTH_SHORT).show();
                    break;
                case -1:
                    Toast.makeText(Registro.this, "Email Incorrecto", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show();
            }
        }



    }

























}