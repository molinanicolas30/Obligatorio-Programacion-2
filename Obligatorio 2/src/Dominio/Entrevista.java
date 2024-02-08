package Dominio;

import Dominio.*;
import java.io.Serializable;
import java.util.*;

public class Entrevista implements Serializable {

    private int numeroEntrevista;
    private Postulante postulante;
    private Evaluador evaluador;
    private int nivel;
    private String comentarios;

    public Entrevista(int numeroEntrevista, Postulante postulante, Evaluador evaluador, int nivel, String comentarios) {
        this.numeroEntrevista = numeroEntrevista;
        this.postulante = postulante;
        this.evaluador = evaluador;
        this.nivel = nivel;
        this.comentarios = comentarios;
    }

    public int getNumeroEntrevista() {
        return numeroEntrevista;
    }

    public Postulante getPostualnte() {
        return postulante;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public int getNivel() {
        return nivel;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setNumeroEntrevista(int numeroEntrevista) {
        this.numeroEntrevista = numeroEntrevista;
    }

}
