package org.example;

import java.util.Scanner;

public class RieraLopezValverdeJoseluis {
    static void main() {
//        ej1();
        ej2();
    }

    public static void ej1 () {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        char letra;
        int cantidadLetras = 0;
        System.out.println("Introduce una frase por teclado:");
        String frase = sc.nextLine();
        frase = frase + ".";
        do {
            contador++;
            letra = frase.charAt(contador);
            if (letra != ' '){
                cantidadLetras++;
            }

        }while (letra != '.');
        System.out.println(cantidadLetras);

    }

    public static void ej2 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase y le doy la vuelta:");
        String frase = sc.nextLine();
        String fraseReves = "" ;
        char letra;
        for (int i = 0; i < frase.length(); i++) {
            letra = frase.charAt(frase.length() - 1 -i );
            fraseReves += letra;
        }

        System.out.println(fraseReves);
    }
}
