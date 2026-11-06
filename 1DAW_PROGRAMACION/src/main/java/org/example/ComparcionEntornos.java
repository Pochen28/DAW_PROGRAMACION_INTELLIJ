package org.example;

import java.util.Scanner;

public class ComparcionEntornos {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una palabra:");
        String palabra = sc.nextLine();
        System.out.println("Cuántas veces quieres que se imprima esa palabra?");
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            System.out.println(palabra);
        }
    }
}
