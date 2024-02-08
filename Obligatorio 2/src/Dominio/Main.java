package Dominio;

import Interfaz.Inicio;
import javax.swing.JFrame;

public class Main {
       
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        JFrame inicio = new Inicio(sistema);
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
    
}
