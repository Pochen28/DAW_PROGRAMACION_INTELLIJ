package org.example;

import java.util.Scanner;

public class ExamenPrueba {

    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String frase;
        char letra;
        System.out.println("Dame una frase que la cuento: ");
        frase = teclado.nextLine();
        frase = frase + ".";
        System.out.println(frase);

    }
}
