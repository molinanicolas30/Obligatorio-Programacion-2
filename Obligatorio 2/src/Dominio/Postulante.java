package Dominio;

import java.io.Serializable;
import java.util.*;

public class Postulante implements Serializable{
    
  private String nombre;
  private String cedula;
  private String direccion;
  private String telefono;
  private String mail;
  private String linkedin;
  private String formato;
  private ArrayList<String> experiencia;
  private ArrayList<Integer> nivelExperiencia;

    public Postulante(String nombre, String cedula, String direccion, String telefono, String mail, String linkedin, String formato, ArrayList<String> experiencia, ArrayList<Integer> nivelExperiencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.linkedin = linkedin;
        this.formato = formato;
        this.experiencia = experiencia;
        this.nivelExperiencia = nivelExperiencia;
    }

    
    public String toString() {
        return this.nombre + "(" + this.cedula + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getFormato() {
        return formato;
    }

    public ArrayList<String> getExperiencia() {
        return experiencia;
    }

    public ArrayList<Integer> getNivelExperiencia() {
        return nivelExperiencia;
    }

    
}