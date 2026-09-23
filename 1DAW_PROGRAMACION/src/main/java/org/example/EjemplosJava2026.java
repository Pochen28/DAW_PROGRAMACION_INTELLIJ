package org.example;

import java.util.Scanner;

public class EjemplosJava2026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Teclea tu nombre por favor");
        nombre = sc.nextLine();
        System.out.println("Tu nombre es: " + nombre.toUpperCase() + " y tiene " + nombre.length() + " letras");
        for (int i = 0; i < nombre.length(); i++) {


        }


    }
}
