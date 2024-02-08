package obligatorio.pkg1.programacion.pkg2;

import java.util.*;

public class Sistema {

    private String[][] matriz;
    private String[][] matrizVieja;
    private int fila;
    private int columna;
    private int nivel;
    private ArrayList<Integer> solucion;
    private ArrayList<Integer> historial;

    public Sistema(int fila, int columna, int nivel, String[][] matriz) {
        this.fila = fila;
        this.columna = columna;
        this.nivel = nivel;

        if (matriz != null) {
            this.matriz = copiarMatriz(matriz);
        } else {
            this.matriz = generarMatrizRandom(fila, columna, nivel);
        }

        this.solucion = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setSolucion(int num) {
        this.solucion.add(num);
    }

    public ArrayList getSolucion() {
        return this.solucion;
    }

    public void setHistorial(int num) {
        this.historial.add(num);
    }

    public ArrayList getHistorial() {
        return this.historial;
    }

    public String[][] getMatriz() {
        return this.matriz;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String[][] getMatrizVieja() {
        return this.matrizVieja;
    }

    // inicializo el arrayList con la solucion de la matriz predefinida de la opcion b
    public void setSolucionB() {
        this.solucion = new ArrayList<>(Arrays.asList(5, 4, 5, 6, 4, 4));
    }

    // esta funcion devuelve genera una matriz random y la devuelve
    public String[][] generarMatrizRandom(int fila, int columna, int nivel) {
        Random random = new Random();
        String rojo = "R";
        String azul = "A";
        String color = "";
        String[][] matrizRandom = new String[fila][columna];
        int azarColor = random.nextInt(2);
        if (azarColor == 0) {
            color = rojo;
        } else {
            color = azul;
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                int azarCaracteres = random.nextInt(4);
                if (azarCaracteres == 0) {
                    matrizRandom[i][j] = "\\" + color;
                } else if (azarCaracteres == 1) {
                    matrizRandom[i][j] = "/" + color;
                } else if (azarCaracteres == 2) {
                    matrizRandom[i][j] = "|" + color;
                } else {
                    matrizRandom[i][j] = "-" + color;
                }
            }
        }
        return matrizRandom;
    }

    // la funcion genera la solucion dependiendo del nivel al azar
    public ArrayList generarSolucion(int nivel, String[][] matriz) {
        Random random = new Random();
        ArrayList<Integer> solucion = new ArrayList<>();
        for (int i = 0; i < nivel; i++) {
            int azarFila = random.nextInt(matriz.length);
            int azarColumna = random.nextInt(matriz[0].length);
            solucion.add(azarFila + 1);
            solucion.add(azarColumna + 1);
        }
        return solucion;
    }

    // copia la matriz que se le pase como parametro
    public String[][] copiarMatriz(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        String[][] nuevaMatriz = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }

        return nuevaMatriz;
    }

    // identifica que funcion utilizar para hacer los cambios de color de la matriz
    public void queImprimir(int fila, int columna) {
        String[][] matriz = getMatriz();
        String barraInversa = "\\";
        String barra = "/";
        String menos = "-";
        String or = "|";
        if (matriz[fila][columna].contains(barraInversa)) {
            diagonalInversa(fila, columna);
        } else {
            if (matriz[fila][columna].contains(barra)) {
                diagonal(fila, columna);
            } else {
                if (matriz[fila][columna].contains(menos)) {
                    horizontal(fila);
                } else {
                    vertical(columna);
                }
            }
        }
    }

    // modifica los colores de la matris verticalmente donde fue seleccionada
    public void vertical(int columna) {
        String[][] matriz = copiarMatriz(this.matriz);
        String[][] matrizNueva = copiarMatriz(this.matriz);
        char rojo = 'R';
        for (int i = 0; i < matrizNueva.length; i++) {
            char color = matrizNueva[i][columna].charAt(1);
            String elemento = "";
            if (color == rojo) {
                elemento = matrizNueva[i][columna].replace("R", "A");
                matrizNueva[i][columna] = elemento;
            } else {
                elemento = matrizNueva[i][columna].replace("A", "R");
                matrizNueva[i][columna] = elemento;
            }
        }
        this.matriz = matrizNueva;
        this.matrizVieja = matriz;

    }

    // modifica los colores de la matris horizontalmente donde fue seleccionada
    public void horizontal(int fila) {
        String[][] matriz = copiarMatriz(this.matriz);
        String[][] matrizNueva = copiarMatriz(this.matriz);
        char rojo = 'R';
        for (int i = 0; i < this.columna; i++) {
            char color = matrizNueva[fila][i].charAt(1);
            String elemento = "";
            if (color == rojo) {
                elemento = matrizNueva[fila][i].replace("R", "A");
                matrizNueva[fila][i] = elemento;
            } else {
                elemento = matrizNueva[fila][i].replace("A", "R");
                matrizNueva[fila][i] = elemento;
            }
        }
        this.matriz = matrizNueva;
        this.matrizVieja = matriz;

    }

    // modifica los colores en la diagonal "/" de la matris donde fue seleccionada
    public void diagonal(int fila, int columna) {
        String[][] matriz = copiarMatriz(this.matriz);
        String[][] matrizNueva = copiarMatriz(this.matriz);
        char rojo = 'R';
        for (int i = fila; i > 0 && (columna + 1) < this.columna; i--) {
            fila--;
            columna++;
        }
        for (int i = fila; i < matrizNueva.length && columna >= 0; i++) {
            char color = matrizNueva[i][columna].charAt(1);
            String elemento = "";
            if (color == rojo) {
                elemento = matrizNueva[i][columna].replace("R", "A");
                matrizNueva[i][columna] = elemento;
            } else {
                elemento = matrizNueva[i][columna].replace("A", "R");
                matrizNueva[i][columna] = elemento;
            }
            columna--;
        }
        this.matriz = matrizNueva;
        this.matrizVieja = matriz;
    }

    // modifica los colores en la diagonal inversa o contra barra "\\" de la matris donde fue seleccionada
    public void diagonalInversa(int fila, int columna) {
        String[][] matriz = copiarMatriz(this.matriz);
        String[][] matrizNueva = copiarMatriz(this.matriz);
        char rojo = 'R';
        for (int i = fila; i > 0 && columna > 0; i--) {
            fila--;
            columna--;
        }
        for (int i = fila; i < matrizNueva.length && columna < this.columna; i++) {
            char color = matrizNueva[i][columna].charAt(1);
            String elemento = "";
            if (color == rojo) {
                elemento = matrizNueva[i][columna].replace("R", "A");
                matrizNueva[i][columna] = elemento;
            } else {
                elemento = matrizNueva[i][columna].replace("A", "R");
                matrizNueva[i][columna] = elemento;
            }
            columna++;
        }
        this.matriz = matrizNueva;
        this.matrizVieja = matriz;
    }

    // verifica que la matriz que se le pase por parametro es toda del mismo color ya sea toda roja o azul
    public boolean esDelMismoColor(String[][] matriz) {
        boolean gano = false;
        char rojo = 'R';
        char blue = 'A';
        int numRojo = 0;
        int numBlue = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                char color = matriz[i][j].charAt(1);
                if (color == rojo) {
                    numRojo++;
                } else {
                    numBlue++;
                }
            }
        }
        if (numRojo == (matriz.length * matriz[0].length)) {
            gano = true;
        } else {
            if (numBlue == (matriz.length * matriz[0].length)) {
                gano = true;
            }
        }
        return gano;
    }

    // esta funcion ingresa los + y - para delimitar los lugares cuando se imprimen 2 matrizes
    public void masYMenos(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        String poner = "+";
        for (int i = 0; i < columnas; i++) {
            poner += "---+";
        }
        System.out.print("   " + poner);
        System.out.print("     ");
        poner = "+";
        for (int i = 0; i < columnas; i++) {
            poner += "---+";
        }
        System.out.print("  " + poner);

    }

    // impreime en consola la matriz vieja y la matriz modificada para visualizar los cambios uno al lado de otro
    public void imprimirDosMatrices() {

        // SON LOS COLORES QUE SE DEBEN PONER EN EL SOUT ANTES DE ESCRIBIT EJ: System.out.print(red + columnas[k]+ reset + "   ");
        // se tiene que poner reset al final para volver al color por defecto de la cosnola porque si no todo quedaria en rojo 
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        int cont = 1;
        String[][] matriz = getMatriz();
        String[][] matrizVieja = getMatrizVieja();

        for (int i = 0; i < matriz.length; i++) {
            //SOLO ENTRA CUANDO I = 0 PARA QUE NO SE VUELVA A PONER LA NUMERACION DE LA COLUMNA OTRA VEZ
            if (i == 0) {
                //con este sout le doy e esoacio al los numeros para que este alineado con los elementos de la matriz
                System.out.print("    ");
                //  recorre la numeracion de la columna y lo pone
                for (int k = 0; k < matriz[0].length * 2; k++) {
                    if (cont > matriz[0].length) {
                        System.out.print("         ");
                        cont = 1;
                    }
                    System.out.print(cont + "   ");
                    cont++;
                }
                System.out.println(" ");
                masYMenos(getMatriz());
                System.out.println(" ");

                cont = 1;

            }

            System.out.print(cont + " | ");
            char rojo = 'R';
            for (int j = 0; j < matrizVieja[0].length; j++) {
                char color = matrizVieja[i][j].charAt(1);
                char caracter = matrizVieja[i][j].charAt(0);
                if (color == rojo) {
                    System.out.print(red + caracter + reset + " | ");
                } else {
                    System.out.print(blue + caracter + reset + " | ");
                }
            }

            System.out.print(" ==> " + cont + " | ");
            cont++;
            for (int j = 0; j < matriz[0].length; j++) {
                char color = matriz[i][j].charAt(1);
                char caracter = matriz[i][j].charAt(0);
                if (color == rojo) {
                    System.out.print(red + caracter + reset + " | ");
                } else {
                    System.out.print(blue + caracter + reset + " | ");
                }
            }
            System.out.println(" ");
            masYMenos(getMatriz());
            System.out.println(" ");
        }
    }

    // esta funcion ingresa los + y - para delimitar los lugares de una matriz
    public void masYMenos1(String[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        String poner = "+";
        for (int i = 0; i < columnas; i++) {
            poner += "---+";
        }
        System.out.println("  " + poner);

    }

    // imprime solo una matriz en consola
    public void imprimirMatriz(String[][] matriz) {
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        int cont = 1;
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                System.out.print("    ");
                for (int k = 0; k < matriz[0].length; k++) {
                    System.out.print(cont + "   ");
                    cont++;
                }
                cont = 1;
                System.out.println("");
                masYMenos1(matriz);
            }
            System.out.print(cont + " | ");
            char rojo = 'R';
            for (int j = 0; j < matriz[0].length; j++) {
                char color = matriz[i][j].charAt(1);
                char caracter = matriz[i][j].charAt(0);
                if (color == rojo) {
                    System.out.print(red + caracter + reset + " | ");
                } else {
                    System.out.print(blue + caracter + reset + " | ");
                }
            }
            System.out.println("");
            masYMenos1(matriz);
            cont++;
        }

    }
}
