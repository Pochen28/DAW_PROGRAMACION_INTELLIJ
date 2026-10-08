package org.example;

import java.util.Scanner;

public class MetodosReturn {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int ejercicio;
        System.out.println("\n\t1. Contador frase");
        System.out.println("\t2. Reverse frase");
        System.out.println("\t3. Reverse frase (version Edu)");

       do {
           System.out.println("\n\n¿Qué ejercicio vas a querer hacer?");
           ejercicio = Integer.parseInt(sc.nextLine());
           switch (ejercicio) {
               case 1:
                   System.out.println("Teclea una frase que la cuento:");
                   String frase1  = sc.nextLine();
                   System.out.println("La frase tiene " + ej1(frase1) + " letras.");
                   break;
               case 2:
                   System.out.println("Introduce una frase y le doy la vuelta:");
                   String frase2 = sc.nextLine();
                   System.out.println("La frase dada la vuelta es " + ej2(frase2));
                   break;
               case 3:
                   System.out.println("Introduce una frase y le doy la vuelta:");
                   String frase3 = sc.nextLine();
                   System.out.println("La solucion de Eduardo a este ejercicio es: " + ej2Eduardo(frase3));
                   break;
               default:
                   System.out.println("Selecciona una opción válda.");
           }
       } while (ejercicio < 1 || ejercicio > 3);


    }


    public static int ej1 (String frase1) {
        int contador = 0;
        char letra;
        int cantidadLetras = 0;
        frase1 = frase1 + ".";
        do {

            letra = frase1.charAt(contador);
            contador++;
            if (letra != ' '){
                cantidadLetras++;
            }

        }while (letra != '.');

        return cantidadLetras -1;

    }
    public static String ej2 (String frase2) {

        String fraseReves = "" ;

        char letra;
        for (int i = 0; i < frase2.length(); i++) {
            letra = frase2.charAt(frase2.length() - 1 -i );
            fraseReves += letra;
        }
        return fraseReves;

    }

    public static String ej2Eduardo (String frase2) {
        String fraseReves = "";
        frase2 = frase2 + ".";
        System.out.println("Solución Eduardo:");
        for (int i = frase2.length() -1; i >= 0; i--) {
            fraseReves += frase2.charAt(i);
        }
        return fraseReves;
    }
}
