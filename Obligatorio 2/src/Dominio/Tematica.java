package Dominio;

import java.io.Serializable;
import java.util.*;

public class Tematica implements Serializable{
    private String nombre;
    private String descripcion;
    
     public Tematica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public String toString() {
        return "Nombre: " + this.nombre + ", Descripcion: " + this.descripcion;
    }
    // Métodos getter
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
}
