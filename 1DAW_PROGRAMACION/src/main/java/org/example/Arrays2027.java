package org.example;

public class Arrays2027 {

    private static String[] alumnado = {"Alex", "Sonia", "Juan", "Pablo", "Mateo", "Yassine", "Gonzalo", "Noel", "Alejandro", "Saul", "Gabriel", "Yaqelyne"};
    private static String[] modulos = {"Programacion", "Entornos", "Marcas", "Bases de datos", "FOL"};

    private static int[][] notas = {
            {7, 7, 5, 5, 8, 4, 4, 4, 4, 4, 4, 4},
            {6, 8, 5, 9, 4, 8, 4, 7, 4, 4, 4, 4},
            {5, 4, 9, 5, 4, 5, 4, 6, 6, 7, 4, 7},
            {4, 4, 9, 8, 4, 9, 4, 9, 7, 8, 9, 6},
            {9, 7, 6, 9, 8, 8, 9, 5, 5, 8, 7, 5}

    };

    static void main(String[] args) {
        // todoAprobado();
         calcularMediasAlumnos();
        mediasExtremas();
    }

    public static void mostrarNotas() {
        System.out.println("Notas por módulos;");

        for (int f = 0; f < notas.length; f++) {
            System.out.println("\nLas notas de " + modulos[f] + ":");
            // También se puede hacer como: for (int c=0; c < notas [f].lenght; c++){}
            for (int c = 0; c < alumnado.length; c++) {
                System.out.print(notas[f][c] + " ");
            }
        }


        System.out.println("\n\nNotas por alumnos");
        for (int c = 0; c < notas[1].length; c++) {
            System.out.println("Las notas de " + alumnado[c] + " son:");
            for (int f = 0; f < notas.length; f++) {
                System.out.print(notas[f][c] + " ");
            }
            System.out.println("");
        }

    }

    public static void calcularMediasModulos () {
        // Medias por módulos
        double total = 0;
        double totalInd = 0;
        for (int f = 0; f < notas.length; f++) {
            totalInd = 0;
            for (int c = 0; c < notas[f].length; c++) {
                total += notas[f][c];
                totalInd += notas[f][c];
            }
            System.out.println("La media de " + modulos[f] + " es " + totalInd / alumnado.length);
        }
        System.out.println("\nLa media general es de: " + total / (alumnado.length * modulos.length));
    }

    private static void calcularMediasAlumnos () {
        double total;
        for (int c = 0; c < notas [1].length; c++) {
            total = 0;
            for (int f = 0; f < notas.length; f++) {
                total  += notas[f][c];
            }
            System.out.println("El alumno " + alumnado[c] + " tiene una media total de " + total/modulos.length);

        }
    }

    public static void calculoSuspensos() {
        int suspensos;
        for (int f = 0; f < notas.length; f++) {
            suspensos = 0;
            for (int c = 0; c < notas[f].length; c++) {
                if (notas[f][c] < 5) {
                    suspensos++;
                }
            }
            System.out.println("En el módulo de " + modulos[f] + " han suspendido " + suspensos + " personas.");

        }
    }

    //Nombres de alumnos que aprueban todo
    public static void todoAprobado () {
        int aprobado;
        for (int c = 0; c < notas[0].length; c++) {
            aprobado = 0;
            for (int f = 0; f < notas.length; f++) {
                if (notas [f] [c] >= 5) {
                    aprobado++;
                }
            }
            if (aprobado == modulos.length) {
                System.out.println(alumnado[c]);
            }

        }
    }

    // Calcular quien tiene la media mas alta y mas baja comparandolas con las del resto
    private static void mediasExtremas () {

        double total;
        double media = 0;
        double mediaAlta = 0;
        double mediaBaja = 10;
        String alumnoAlta = "";
        String alumnoBaja = "";

        for (int c = 0; c < notas [1].length; c++) {
            total = 0;
            for (int f = 0; f < notas.length; f++) {
                media =+ notas[f][c];
            }
            media = media/modulos.length;
            if (media > mediaAlta) {
                mediaAlta = media;
                alumnoAlta = alumnado [c];
            }

            if (media < mediaBaja) {
                mediaBaja = media;
                alumnoBaja = alumnado [c];
            }

        }
        System.out.println(mediaAlta + " " + alumnoAlta);
        System.out.println(mediaBaja + " " + alumnoBaja);
    }



}
