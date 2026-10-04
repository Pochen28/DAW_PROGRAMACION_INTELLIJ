package org.example;

import java.util.Scanner;

public class EjemplosBucles {
    public static void main(String[] args) {

        menu();
         // ej5();
         // ej6();
        // ej6Diferente();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("\n\n\n\t\tAGENDA DE CONTACTO");
            System.out.println("\n\t\t\t1. Añadir contacto.");
            System.out.println("\n\t\t\t2. Borrar contacto.");
            System.out.println("\n\t\t\t3. Modificar contacto.");
            System.out.println("\n\t\t\t4. Buscar contacto.");
            System.out.println("\n\t\t\t5. Ver todos los contactos.");
            System.out.println("\n\t\t\t6. Salir.");

            System.out.println("\n\nIntroduce el número del menú de lo que deseas hacer: ");
            num = sc.nextInt();

            switch (num) {
                case 1:
                    anyadirContacto();
                    break;
                case 2:
                    borrarContacto();
                    break;
                case 3:
                    modificarContacto();
                    break;
                case 4:
                    buscarContacto();
                    break;
                case 5:
                    verContactos();
                    break;
                case 6:
                    salirAplicacion();
                    break;
                default:
                    System.out.println("Opcion no permitida");
                    break;
            }
        } while (num != 6);
    }

    public static void anyadirContacto() {

        System.out.println("HAS SELECCIONADO AÑADIR CONTACTO");
    }

    public static void borrarContacto() {

        System.out.println("HAS SELECCIONADO BORRAR CONTACTO");
    }

    public static void modificarContacto() {
        System.out.println("HAS SELECCIONADO MODIFICAR CONTACTO");
    }

    public static void buscarContacto() {
        System.out.println("HAS SELECCIONADO BUSCAR CONTACTO");
    }

    public static void verContactos() {
        System.out.println("HAS SELECCIONADO VER TODOS LOS CONTACTOS");
    }

    public static void salirAplicacion() {
        System.out.println("HAS SELECCIONADO SALIR DE LA APLICACIÓN");
    }

    public static void ej5() {
        Scanner sc = new Scanner(System.in);
        int num;
        int total = 0;
        while (total < 100) {
            System.out.print("Teclea un número entero: ");
            num = sc.nextInt();
            total = total + num;
        }
    }

    private static void ej6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Teclea una frase:");
        String frase = sc.nextLine();
        System.out.println("Teclea una letra o un carácter simple:");
        char letra;
        letra = sc.next().charAt(0);
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }

        }
        if (contador == 0) {
            System.out.println("La letra " + letra + " no se encuentra en el texto.");
        } else if (contador == 1) {
            System.out.println("La letra " + letra + " sólo se encuentra una vez.");
        }else {
            System.out.println("La letra " + letra + " se encuentra " + contador + " veces en el texto.");
        }

        System.out.println("\n\nProceso mediante otro método que devuelve: ");
        System.out.println("La letra " + letra + " se repite " + vecesLetraEnFrase(frase, letra) + " veces em la frase.");


    }
    public static void ej6Diferente (){
        Scanner sc = new Scanner(System.in);

        String frasefinal = "";
        System.out.println("Teclea una frase:");
        String frase = sc.nextLine();
        System.out.println("Teclea una letra o un carácter simple:");
        String letra = sc.nextLine();
        int contador = 0;

        if (frase.contains(letra)){
            frasefinal = frase.replace(letra, "");
            contador = frase.length() - frasefinal.length();
        }
        System.out.println(contador + " veces.");
    }

    private static int vecesLetraEnFrase (String frase, char letra) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }

}
