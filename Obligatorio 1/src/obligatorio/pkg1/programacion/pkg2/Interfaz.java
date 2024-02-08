package obligatorio.pkg1.programacion.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import obligatorio.pkg1.programacion.pkg2.Sistema;

public class Interfaz {

    private Sistema sistema;  // Agrega una instancia de Sistema

    // primer funcion que pregunta quiere jugar y que opcion elegir 
    public void comenzarJuego() {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Desea jugar? si/no");
        String desea = sc.nextLine().toLowerCase();
        while (!desea.equals("si") && !desea.equals("s") && !desea.equals("no") && !desea.equals("n")) {
            System.out.println("¿Desea jugar? si/no");
            desea = sc.nextLine().toLowerCase();
        }
        if (desea.equals("no") || desea.equals("n")) {
            System.out.println("Lo entiendo no quieres jugar conmigo :(");
        } else {
            if (desea.equals("si") || desea.equals("s")) {
                boolean sigo = true;
                sistema = null;
                while (sigo) {
                    System.out.println("a) Tomar datos del archivo “datos.txt”");
                    System.out.println("b) Usar el tablero predefinido");
                    System.out.println("c) Usar un tablero al azar");
                    System.out.println("X) Salir");
                    System.out.println("");
                    System.out.print("Ingrese su opcion: ");
                    String opcion = sc.nextLine();
                    if (opcion.equals("a")) {
                        opcionA(sigo);
                        sigo = seguirJugando(sigo);
                    } else {
                        if (opcion.equals("b")) {
                            String[][] predefinida = {
                                {"|A", "|A", "-R", "/A", "|R", "-R"},
                                {"-R", "/A", "/A", "|A", "-R", "-R"},
                                {"-R", "-R", "|A", "-R", "/R", "-R"},
                                {"\\R", "-R", "|R", "\\R", "|A", "|R"},
                                {"\\R", "/R", "/R", "|A", "/A", "\\A"}
                            };
                            sistema = new Sistema(5, 6, 3, predefinida);
                            sistema.setSolucionB();
                            String[][] matriz = sistema.getMatriz();
                            opcionB(matriz);
                            sigo = seguirJugando(sigo);

                        } else {
                            if (opcion.equals("c")) {
                                opcionC();
                                sigo = seguirJugando(sigo);
                            } else {
                                if (opcion.equals("x")) {
                                    sigo = false;
                                } else {
                                    System.out.println("Porfavor ingrese una de estas opciones");
                                }
                            }
                        }
                    }
                }
                System.out.println("Muchas gracias por jugar, te espero en la proxima!!");
            }
        }
    }

    //opcion donde lee el archivo datos.txt
    public void opcionA(boolean sigo) {
        String rutaArchivo = ".\\Test\\datos.txt";

        try {
            // Crea un objeto Scanner para leer el archivo
            Scanner sc = new Scanner(new File(rutaArchivo));
            ArrayList<Integer> solucion = new ArrayList<Integer>();
            int N = sc.nextInt();
            int M = sc.nextInt();
            String[][] matriz = new String[N][M];
            sc.nextLine();
            matriz = new String[N][M];
            for (int i = 0; i < N; i++) {
                String linea = sc.nextLine();
                String[] array = linea.split(" ");
                for (int j = 0; j < M; j++) {
                    matriz[i][j] = array[j];
                }
            }
            int nivel = sc.nextInt();
            sistema = new Sistema(N, M, nivel, matriz);
            sc.nextLine();
            for (int k = 0; k < nivel; k++) {
                String fila = sc.nextLine();
                String[] arrayS = fila.split(" ");
                sistema.setSolucion(Integer.parseInt(arrayS[0]));
                sistema.setSolucion(Integer.parseInt(arrayS[1]));
            }
            long tiempoInicio = System.currentTimeMillis();
            jugar(tiempoInicio);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }

    }

    // opcion predefinida
    public void opcionB(String[][] predefinida) {
        boolean sigo = true;
        long tiempoInicio = System.currentTimeMillis();
        jugar(tiempoInicio);

    }

    // opcion donde el usuario crea la matriz y elije el nivel de dificultad y se genera al azar
    public void opcionC() {

        int fila = pedirYDevolverNumero(1, 9, "fila", true);

        int columna = pedirYDevolverNumero(1, 9, "columna", true);

        int nivel = pedirYDevolverNumero(1, 8, "nivel", true);

        sistema = new Sistema(fila, columna, nivel, null);
        ArrayList<Integer> solucion = sistema.generarSolucion(nivel, sistema.getMatriz());
        for (int i = 0; i < solucion.size(); i += 2) {
            int fil = solucion.get(i);
            int colu = solucion.get(i + 1);
            sistema.setSolucion(fil);
            sistema.setSolucion(colu);
            fil--;
            colu--;
            sistema.queImprimir(fil, colu);
        }
        long tiempoInicio = System.currentTimeMillis();
        jugar(tiempoInicio);
    }

    // en esta funcion esta toda la funcionalidad del juego en si, que se pregunta al usuario (Ingrese X, H, S o fila:) 
    public boolean jugar(long tiempoInicio) {
        Scanner sc = new Scanner(System.in);
        boolean sigo = true;
        int num = 0;
        boolean solu = true;
        while (sigo) {
            String[][] matriz = sistema.getMatriz();
            String[][] matrizVieja = sistema.getMatrizVieja();
            if (sistema.esDelMismoColor(matriz)) {
                long tiempoFin = System.currentTimeMillis();
                long duracion = (tiempoFin - tiempoInicio) / 1000;
                sistema.imprimirMatriz(matriz);
                System.out.println("Ganaste!!!");
                System.out.println("");
                System.out.println("Tiempo de juego: " + duracion + " segundos");
                System.out.println("");
                sigo = false;
                break;
            }
            if (num == 0) {
                sistema.imprimirMatriz(matriz);
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
            }
            if (num != 0 && solu) {
                sistema.imprimirDosMatrices();
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
            }
            if (!solu) {
                solu = true;
            }

            ArrayList<Integer> solucion = sistema.getSolucion();
            ArrayList<Integer> historial = sistema.getHistorial();

            System.out.print("Ingrese X, H, S o fila: ");
            String entrada = sc.nextLine().toUpperCase();
            while (entrada.isEmpty()) {
                System.out.println("Entrada vacia. Por favor, ingrese una opcion valida.");
                entrada = sc.nextLine().toUpperCase();
            }
            char opcion = entrada.charAt(0);
            switch (opcion) {
                case 'X':
                    System.out.println("Hasta la proxima");
                    sigo = false;
                    break;
                case 'H':
                    if (historial.size() == 0) {
                        System.out.println("No ha hecho ningun movimiento");
                        solu = false;
                    } else {
                        System.out.println("El historial de sus movimientos es:");
                        for (int j = historial.size() - 1; j >= 0; j -= 2) {
                            System.out.print(historial.get(j - 1));
                            System.out.print(" ");
                            System.out.print(historial.get(j));
                            System.out.println("");
                            solu = false;
                        }
                    }
                    break;
                case 'S':
                    System.out.println("La solcion es:");
                    for (int j = solucion.size() - 1; j >= 0; j -= 2) {
                        System.out.print(solucion.get(j - 1));
                        System.out.print(" ");
                        System.out.print(solucion.get(j));
                        System.out.println("");
                        solu = false;
                    }
                    break;
                default:
                    if (esNumero(entrada)) {
                        int fila = Integer.parseInt(entrada);
                        if (fila != -1) {
                            String linea = "";
                            while (fila > matriz.length || fila <= 0) {
                                System.out.println("Ingrese valores de 1 a " + matriz.length + " incluyendolos");
                                System.out.print("Ingrese fila: ");
                                linea = sc.nextLine();
                                while (!esNumero(linea)) {
                                    System.out.print("Debe ser un numero");
                                    linea = sc.nextLine();
                                }
                                fila = Integer.parseInt(linea);
                            }

                            int columna = pedirYDevolverNumero(1, matriz[0].length, "columna", false);

                            int filaSolu = solucion.get(solucion.size() - 2);
                            int columnaSolu = solucion.get(solucion.size() - 1);
                            // en caso se se elija un movimiento de la solucion se elimina de la solucion
                            if (fila == filaSolu && columna == columnaSolu) {
                                solucion.remove(solucion.size() - 2);
                                solucion.remove(solucion.size() - 1);
                            } else {
                                sistema.setSolucion(fila);
                                sistema.setSolucion(columna);
                            }
                            // agrega los movimientos a la solucion y al historial
                            sistema.setHistorial(fila);
                            sistema.setHistorial(columna);
                            fila--;
                            columna--;
                            sistema.queImprimir(fila, columna);

                        } else {
                            // aca es la opcion para el -1 que quita dos numeros de la solucion y del historial
                            int nivel = sistema.getNivel() * 2;
                            int size = solucion.size();
                            if (size > nivel) {
                                int cont = 0;
                                for (int i = solucion.size() - 1; i >= 0 && cont != 1; i -= 2) {
                                    int N = solucion.get(i - 1);
                                    int M = solucion.get(i);
                                    sistema.queImprimir(N - 1, M - 1);
                                    solucion.remove(i);
                                    solucion.remove(i - 1);
                                    cont++;
                                }
                                cont = 0;
                                for (int i = historial.size() - 1; i >= 0 && cont != 1; i -= 2) {
                                    historial.remove(i);
                                    historial.remove(i - 1);
                                    cont++;
                                }
                            } else {
                                // entra en esta opcion cuando ya no hay mas movimientos que sacar, solo quedarian los de la solucion
                                System.out.println("no hay movimientos a realizar");
                                solu = false;
                            }
                        }
                    } else {
                        // hace que vuelva al bucle de preguntar (Ingrese X, H, S o fila:)
                        System.out.println("Opcion incorrecta");
                        solu = false;
                    }
                    break;
            }
            num++;
        }
        return sigo;
    }

    // esta funcion verifica que el string que se le pase es numero, si no devuelve false
    public boolean esNumero(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // esta funccion pide un numero y hasta que no cumpla con los requisitos que se le pasa no sale del bucle
    public int pedirYDevolverNumero(int min, int max, String text, boolean cantidad) {
        Scanner sc = new Scanner(System.in);
        String linea = "";
        if (cantidad) {
            System.out.print("Ingrese cuantidad de " + text + ": ");
            linea = sc.nextLine();
        } else {
            System.out.print("Ingrese " + text + ": ");
            linea = sc.nextLine();
        }

        while (!esNumero(linea)) {
            System.out.print("Debe ser un numero: ");
            linea = sc.nextLine();
        }
        int numero = Integer.parseInt(linea);
        while (numero < min || numero > max) {
            System.out.println("Ingrese valores de " + min + " a " + max + " incluyendolos");
            System.out.print("Ingrese " + text + ": ");
            linea = sc.nextLine();
            while (!esNumero(linea)) {
                System.out.print("Debe ser un numero: ");
                linea = sc.nextLine();
            }
            numero = Integer.parseInt(linea);
        }

        return numero;
    }

    // esta funcion pregunta si el usuario decea seguir jugando
    public boolean seguirJugando(boolean sigo) {
        Scanner sc = new Scanner(System.in);
        sigo = false;
        System.out.println("¿Desea seguir jugando?");
        System.out.print("si/no: ");
        String pregunta = sc.nextLine();
        while (!(pregunta.equals("si") || pregunta.equals("s") || pregunta.equals("no") || pregunta.equals("n"))) {
            System.out.print("Opcion incorrecta, ingrese de nuevo si/no: ");
            pregunta = sc.nextLine();
        }
        if (pregunta.equals("si") || pregunta.equals("s")) {
            sigo = true;
        }
        return sigo;
    }

}
