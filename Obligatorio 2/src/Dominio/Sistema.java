package Dominio;

import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.*;
import javax.swing.JOptionPane;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Postulante> listaPostulantes = new ArrayList<>();
    private ArrayList<Tematica> listaTemas = new ArrayList<>();
    private ArrayList<Evaluador> listaEvaluadores = new ArrayList<>();
    private ArrayList<Puesto> listaPuestos = new ArrayList<>();
    private ArrayList<Entrevista> listaEntrevistas = new ArrayList<>();

    //metodos get
    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }

    public ArrayList<Tematica> getListaTemas() {
        return listaTemas;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    //Agregar objetos a ArrayList
    public void agregarPostulante(Postulante postu) {
        listaPostulantes.add(postu);
        setChanged();
        notifyObservers();
    }

    public void agregarEvaluador(Evaluador ev) {
        listaEvaluadores.add(ev);
        setChanged();
        notifyObservers();
    }

    public void agregarTematica(Tematica tema) {
        listaTemas.add(tema);
        setChanged();
        notifyObservers();
    }

    public void agregarPuesto(Puesto puesto) {
        listaPuestos.add(puesto);
        setChanged();
        notifyObservers();
    }

    public void agregarEntrevista(Entrevista entrevista) {
        listaEntrevistas.add(entrevista);
        setChanged();
        notifyObservers();
    }

    //Verificar si se repite
    public boolean seRepiteTema(String nombre) {
        boolean next = false;
        for (Tematica tema : listaTemas) {
            String temaNombre = tema.getNombre();
            if (temaNombre.equalsIgnoreCase(nombre)) {
                next = true;
            }
        }
        return next;
    }

    public boolean seRepitePuesto(String nombre) {
        boolean next = false;
        for (Puesto tema : listaPuestos) {
            String puestoNombre = tema.getNombre();
            if (puestoNombre.equalsIgnoreCase(nombre)) {
                next = true;
            }
        }
        return next;
    }

    //Eliminar
    public void eliminarPostulante(String cedula) {
        int numeroENTREVISTA = 1;
        Postulante poss = null;
        if (listaEntrevistas.isEmpty()) {
            for (Postulante postu : listaPostulantes) {
                String ci = postu.getCedula();
                if (ci.equalsIgnoreCase(cedula)) {
                    listaPostulantes.remove(postu);
                    break;
                }
            }
        } else {
            ArrayList<Entrevista> nuevaListaEntrevista = new ArrayList<>();
            for (Entrevista entrevista : listaEntrevistas) {
                Postulante post = entrevista.getPostualnte();
                String ci = post.getCedula();
                int numEntrevista = entrevista.getNumeroEntrevista();
                System.out.println("cedula1 " + ci + " cedula2 " + cedula);
                if (!ci.equalsIgnoreCase(cedula)) {
                    nuevaListaEntrevista.add(entrevista);
                } else {
                    poss = post;
                    System.out.println(post.getCedula());
                }
            }
            listaEntrevistas = new ArrayList<>(nuevaListaEntrevista);
            listaPostulantes.remove(poss);
            for (Entrevista entrevista : listaEntrevistas) {
                entrevista.setNumeroEntrevista(numeroENTREVISTA);
                numeroENTREVISTA++;
            }
        }
        setChanged();
        notifyObservers();
    }

    // funciones que devuelven el objeto
    public Evaluador devolverEvaluador(int cedula) {
        Evaluador evalu = null;

        for (Evaluador elEvaluador : listaEvaluadores) {
            int cedulaEv = elEvaluador.getCedula();
            if (cedulaEv == cedula) {
                evalu = elEvaluador;
            }
        }
        return evalu;
    }

    public Postulante devolverPostulante(String cedula) {
        Postulante postu = null;
        for (Postulante postulante : listaPostulantes) {
            String cedulaPo = postulante.getCedula();
            if (cedulaPo.equalsIgnoreCase(cedula)) {
                postu = postulante;
            }
        }
        return postu;
    }

    public Puesto devolverPuesto(String nombre) {
        Puesto puesto = null;
        for (Puesto p : listaPuestos) {
            if (p.getNombre().equals(nombre)) {
                puesto = p;
            }
        }
        return puesto;
    }

    public int devolverNumEntrevista() {
        int numeroEntrevista = listaEntrevistas.size() + 1;

        return numeroEntrevista;
    }

    public ArrayList<Entrevista> devolverPostulantesConEntrevista() {
        ArrayList<Entrevista> entrevistas = new ArrayList<>();

        // Ordenar la lista clonada por nivel en orden decreciente
        for (int i = listaEntrevistas.size() - 1; i >= 0; i--) {
            Entrevista entrevista = listaEntrevistas.get(i);
            Postulante post = entrevista.getPostualnte();
            boolean esta = false;
            for (Entrevista entre : entrevistas) {
                Postulante postu = entre.getPostualnte();
                if (post.equals(postu)) {
                    esta = true;
                }
            }
            if (!esta) {
                entrevistas.add(entrevista);
            }
            Collections.sort(entrevistas, Comparator.comparingInt(Entrevista::getNivel));
        }
        return entrevistas;
    }

    public ArrayList<String> devolverTemasRequePuesto(String nomPuesto) {
        ArrayList<String> temasRequeridos = new ArrayList<>();
        for (Puesto puesto : listaPuestos) {
            if (nomPuesto.equals(puesto.getNombre())) {
                temasRequeridos = puesto.getTema();
            }
        }
        return temasRequeridos;
    }

    public boolean verificarCedula(String cedula) {
        if (!cedula.matches("\\d+") || cedula.length() != 8) {
            return false;
        }
        return true;
    }

    public boolean seRepiteCedula(String cedula) {
        for (Postulante postulante : listaPostulantes) {
            if (cedula.equals(postulante.getCedula())) {
                return true;
            }
        }
        
        
         int numCedula = Integer.parseInt(cedula);
        for (Evaluador evaluador : listaEvaluadores) {
            if (numCedula == evaluador.getCedula()) {
                return true;
            }
        }
        return false;
    }

}
