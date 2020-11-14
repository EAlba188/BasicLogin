package com.example.examenpilar;

import java.util.ArrayList;

public class ListaUsuarios {

    protected ArrayList<Users> lista;
    protected String nom;

    public ListaUsuarios(String nom){
        this.nom=nom;
        this.lista=new ArrayList<>();
    }

    public int añadirUsuario(String email, String pass, String nombre){
        int numArrobas=0;
        int longitudEmail= email.length();
        int numPuntos=0;
        Users nuevo;
        int res=0;

        for (int i=0; i<longitudEmail; i++){
            if(email.charAt(i) == '@'){
                numArrobas++;
            }
            if(email.charAt(i)=='.'){
                numPuntos++;
            }
            if(email.charAt(0) == '@' || email.charAt(longitudEmail-1) == '@' || email.charAt(0) == '.' || email.charAt(longitudEmail-1) == '.'){
                numArrobas+=10;
            }


        }

        if(numArrobas==1 && numPuntos>0){      // Si devuelve 1 la contraseña es correcta;
            nuevo = new Users(pass,email,nombre);
            lista.add(nuevo);
            res=1;
        }else{                              // Si devuelve -1 el mail no es correcto
            res=-1;
        }
        if(nombre.equalsIgnoreCase("")){    // Si devuelve 5 el nombre esta vacio
            res=5;
        }
        if(pass.length()<7){        // Si sale 0 la contaseña debe ser mayor;
            res=0;
        }


        return res;

    }

    public String getNombreFind(String email){
        String res="";
        for(Users u : lista){
            if(u.getEmail().equalsIgnoreCase(email)){
                res = u.getNombre();
            }
        }
        return res;
    }


    public boolean existeUsuario(String email, String pass){
        boolean res = false;
        int i=0;
        Users user;

        while(i<lista.size() && res==false){
            user=lista.get(i);
            if(user.getEmail().equalsIgnoreCase(email)){
                res=true;
            }
            i++;
        }
        return res;
    }


}
