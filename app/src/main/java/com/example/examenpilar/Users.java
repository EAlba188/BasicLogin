package com.example.examenpilar;

public class Users {

    protected String pass;
    protected String email;
    protected String nombre;

    public Users(String pass, String email, String nombre){
        this.email=email;
        this.pass=pass;
        this.nombre=nombre;
    }


    

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
