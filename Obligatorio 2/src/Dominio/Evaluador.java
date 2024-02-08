package Dominio;

import java.io.Serializable;
import java.util.*;

public class Evaluador implements Serializable{
    private String nombre;
  private int cedula;
  private String direccion;
  private int yearIngreso;

    public Evaluador(String nombre, int cedula, String direccion, int yearIngreso) {
        
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.yearIngreso = yearIngreso;
        
    }
      public String toString() {
        return this.nombre + "(" + this.cedula + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getYearIngreso() {
        return yearIngreso;
    }
    
}
