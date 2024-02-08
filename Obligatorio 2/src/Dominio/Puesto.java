package Dominio;

import java.io.Serializable;
import java.util.*;

public class Puesto implements Serializable{
    private String nombre;
    private String tipo;
    private ArrayList<String> tema;
    
    public Puesto(String nom_puesto, String tipo, ArrayList tema_req){
    
        this.nombre = nom_puesto;
        this.tipo = tipo;
        this.tema = tema_req;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getTema() {
        return tema;
    }
  
}
