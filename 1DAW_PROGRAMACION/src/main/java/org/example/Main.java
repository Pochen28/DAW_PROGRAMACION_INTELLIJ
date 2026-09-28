package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        diaSemana();

    }

    public static void diaSemana(){
        Scanner sc = new Scanner(System.in);
        boolean repetir = false;
        while (!repetir){
            repetir = true;
            System.out.println("Teclea un día de la semana en número: ");
            int num;
            num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("El día " + num + " es lunes.");
                    break;
                case 2:  System.out.println("El día " + num + " es martes.");
                    break;
                case 3:  System.out.println("El día " + num + " es miércoles.");
                    break;
                case 4:  System.out.println("El día " + num + " es jueves.");
                    break;
                case 5: System.out.println("El día " + num + " es viernes.");
                    break;
                case 6: System.out.println("El día " + num + " es sábado.");
                    break;
                case 7:  System.out.println("El día " + num + " es domingo.");
                    break;
                default:
                    System.out.println("El día tecleado es incorrecto.");
                    repetir = false;
                break;
            }
        }

    }
}
