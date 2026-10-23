package org.example.RieraLopez;

import java.util.Arrays;
import java.util.Scanner;

public class Joseluis {
    static void main(String Args[]) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();

    }

    private static String[] alumnado = {"Alex", "Sonia", "Juan", "Pablo", "Mateo", "Yassine", "Gonzalo", "Noel", "Alejandro", "Saul", "Gabriel", "Yaqelyne"};
    private static String[] modulos = {"Programacion", "Entornos", "Marcas", "Bases de datos", "FOL"};

    private static int[][] notas = {
            {7, 7, 5, 5, 8, 4, 4, 4, 4, 4, 4, 4},
            {6, 8, 5, 9, 4, 8, 4, 7, 4, 4, 4, 4},
            {5, 4, 9, 5, 4, 5, 4, 6, 6, 7, 4, 7},
            {4, 4, 9, 8, 4, 9, 4, 9, 7, 8, 9, 6},
            {9, 7, 6, 9, 8, 8, 4, 5, 5, 8, 7, 5}

    };
    private static int [] notasProgramacion = {6,7,5,4,5,5,9,8,4,4,8,9};

    private static void ejercicio1 (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno:");
        String nombre = sc.nextLine();
        for (int i = 0; i < alumnado.length; i++) {
            if (alumnado[i].equals(nombre)) {
                System.out.println("La nota de programación del alumno " + alumnado[i] + " es: " + notasProgramacion[i]);
                return;
            }

        }
        System.out.println("No se ha podido encontrar al alumno en la lista.");
    }

    private static void ejercicio2(){
        int notaAlta = 0;
        int notaBaja = 10;
        String alumnoAlta = "";
        String alumnoBaja = "";
        for (int i = 0; i < notasProgramacion.length; i++) {


            if(notasProgramacion [i] > notaAlta){
                notaAlta = notas[0][i];
                alumnoAlta = alumnado[i];
            }

            if(notasProgramacion [i] < notaBaja){
                notaBaja = notas[0][i];
                alumnoBaja = alumnado[i];
            }


        }
        System.out.println("La nota más alta es de: " + alumnoAlta);
        System.out.println("la nota más baja es de: " + alumnoBaja);
    }

    private static void ejercicio3(){
        int suspensos;
        int todoSuspensos = 0;
        String [] suspendidos = new String[alumnado.length];
        for (int a = 0; a < notas [0].length; a++) {
            suspensos = 0;
            for (int m = 0; m < notas.length; m++) {
                if (notas[m] [a] < 5){
                    suspensos++;
                }
                if (suspensos == 5) {
                    suspendidos [a] = alumnado [a];
                    todoSuspensos ++;

                }
            }

        }
        System.out.println("Han suspendido " + todoSuspensos + " alumno/s");

        System.out.println(Arrays.toString(suspendidos));


    }

    private static void ejercicio4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del módulo:");
        String modulo = sc.nextLine();
        System.out.println("Introduce el nombre del alumno:");
        String nombre = sc.nextLine();
        for (int m = 0; m < notas.length; m++) {
            if (modulo.equals(modulos [m])) {
                for (int a = 0; a < notas [m].length; a++) {
                    if (nombre.equals(alumnado[a])){
                        System.out.println("La nota de " + alumnado[a] + " en el módulo de " + modulos [m] + " es: " + notas[m][a]);
                        return;
                    }else if (a == alumnado.length -1){
                        System.out.println("No se ha encontrado al alumno.");
                    }
                }
            }else if (m == modulos.length -1) {

                System.out.println("No se ha encontrado el módulo.");

            }
        }
    }

}
