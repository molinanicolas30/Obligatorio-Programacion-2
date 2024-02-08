package Dominio;

import java.io.*;

public class Persistencia {

    public static void guardarDatos(Sistema sistema, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(sistema);
            System.out.println("Datos guardados con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores: puede registrar el error, mostrar un mensaje, etc.
        }
    }

    public static Sistema cargarDatos(String archivo) {
        Sistema sistema = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            sistema = (Sistema) ois.readObject();
            System.out.println("Datos cargados con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Manejo de errores: puede registrar el error, mostrar un mensaje, etc.
        }
        return sistema;
    }
}
