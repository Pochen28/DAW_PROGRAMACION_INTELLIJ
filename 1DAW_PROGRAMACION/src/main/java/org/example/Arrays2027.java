package org.example;

public class Arrays2027 {

    private static String [] alumnado  = {"Alex", "Sonia", "Juan" ,"Pablo", " Mateo", "Yassine", "Gonzalo", "Noel", "Alejandro", "Saul", "Gabriel", "Yaqelyne"};
    private static String [] modulos = {"Programacion", "Entornos", "Marcas" , "Bases de datos", "FOL"};

    private static int [][] notas = {
            {7,7,5,5,8,4,4,4,4,4,4,4},
            {6,8,5,9,4,8,4,7,4,4,4,4},
            {5,4,9,5,4,5,4,6,6,7,4,7},
            {4,4,9,8,4,9,4,9,7,8,9,6},
            {9,7,6,9,8,8,9,5,5,8,7,5}

    };
    static void main() {
        mostrarNotas();
    }

    public static void mostrarNotas () {
        System.out.println("Notas por módulos;");

        for (int f=0; f <notas.length; f++ ) {
            System.out.println("\nLas notas de " + modulos[f] + ":");
            // También se puede hacer como: for (int c=0; c < notas [f].lenght; c++){}
            for (int c=0; c < alumnado.length; c++ ) {
                System.out.print(notas [f] [c] + " ");
            }
        }

        System.out.println("\n\nNotas por alumnos");
        for (int c=0; c <notas [1].length; c++ ) {
            System.out.println("Las notas de " + alumnado [c] + " son:");
            for (int f = 0; f < notas.length; f++) {
                System.out.print(notas [f] [c] + " ");
            }
            System.out.println("");
        }

        double total = 0;
        double totalInd = 0;
        for (int f = 0; f < notas.length; f++) {
            totalInd = 0;
            for (int c = 0; c < notas [f].length ; c++) {
                total += notas [f] [c];
            }
            System.out.println("La media de " + modulos[f] + " es " + totalInd/ alumnado.length);
        }
        System.out.println("La media  es: " + total/(alumnado.length* modulos.length));
    }
}
