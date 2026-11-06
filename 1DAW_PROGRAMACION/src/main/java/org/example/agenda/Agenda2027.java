package org.example.agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Agenda2027 {

    private static ArrayList <Contacto> agenda=new ArrayList();

    public static void main(String[] args) {
        cargaDatos();
//        menu();
        compararContactos();

    }

    public static void cargaDatos() {
        agenda.add(new Contacto("Ana", "666666000", "ana@hotmail.com ", LocalDate.parse("2006-04-18"),"facebook"));
        agenda.add(new Contacto("Pepe", "666666111", "pepe@hotmail.com", LocalDate.parse("2016-04-18"),"instagram"));
        agenda.add(new Contacto("Eva", "666666222", "eva@hotmail.com ", LocalDate.parse("1996-04-19"),"facebook"));
        agenda.add(new Contacto("Julia", "666666333", "julia@hotmail.com", LocalDate.parse("2000-04-19"),"instagram"));
        agenda.add(new Contacto("Luis", "666666444", "luis@hotmail.com", LocalDate.parse("2004-04-04"),"facebook"));
        agenda.add(new Contacto("Bea", "666666555", "bea@hotmail.com ", LocalDate.parse("2005-05-05"),"instagram"));
        agenda.add(new Contacto("Lucas", "666666666", "lucas@hotmail.com", LocalDate.parse("2006-12-02"),"TikTok"));
        agenda.add(new Contacto("Olivia", "666666777", "olivia@hotmail.com", LocalDate.parse("2007-02-28"),"TikTok"));
        agenda.add(new Contacto("Tomas", "666666888", "tomas@hotmail.com", LocalDate.parse("2008-12-02"),"TikTok"));
        agenda.add(new Contacto("Marta", "666666999", "marta@hotmail.com", LocalDate.parse("2009-11-27"),"instagram"));
    }



    private static void menu(){
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t----------------");
            System.out.println("\n\t\t\t1. AÑADIR CONTACTO");
            System.out.println("\t\t\t2. ELIMINAR CONTACTO");
            System.out.println("\t\t\t3. MODIFICAR CONTACTO");
            System.out.println("\t\t\t4. BUSCAR CONTACTO");
            System.out.println("\t\t\t5. LISTAR CONTACTOS");
            System.out.println("\t\t\t6. SALIR DE LA AGENDA");
            System.out.println("\n\nTeclea una opción:");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> añadirContacto();
                case 2 -> eliminarContacto();
                case 3 -> modificarContacto();
                case 4 -> buscarContacto();
                case 5 -> listarContactos();
                case 6 -> System.out.println("Salida de la aplicación");
                default -> System.out.println("Has tecleado una opción incorrecta");
            }
        }while (opcion !=6);
    }

    private static void añadirContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Alta de un contacto nuevo:");
        System.out.print("Nombre:");
        String nombre=sc.nextLine();
        System.out.print("Telefono:");
        String telefono=sc.nextLine();
        System.out.print("Email:");
        String email=sc.nextLine();
        System.out.println("Fecha de Nacimiento (AAAA-MM-DD):");
        String fecha=sc.nextLine();
        System.out.println("Redes sociales:");
        String redes=sc.nextLine();
        agenda.add(new Contacto(nombre,telefono,email,LocalDate.parse(fecha),redes));
    }

    private static void eliminarContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Borrado de contactos:");
        System.out.print("Nombre:");
        String nombre=sc.nextLine();
        int pos=-1;
        for (int i=0;i<agenda.size();i++){
            if(agenda.get(i).getNombre().equalsIgnoreCase(nombre)){
                pos=i;
                break;
            }
        }
        if (pos==-1){
            System.out.println("Ese nombre no está en la agenda");
        }else{
            agenda.remove(pos);
            System.out.println("Contacto eliminado");
        }

    }

    private static void modificarContacto() {
        System.out.println("Estaríamos en el método para modificar un contacto");
    }

    private static void buscarContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Buscar Contacto:");
        System.out.print("Nombre:");
        String nombre=sc.nextLine();
        int pos=-1;
        for (int i=0;i<agenda.size();i++){
            if(agenda.get(i).getNombre().equalsIgnoreCase(nombre)){
                pos=i;
                break;
            }
        }
        if (pos==-1){
            System.out.println("Ese nombre no está en la agenda");
        }else{
            System.out.println("\t\tLos datos del contacto: " + nombre + " son:");
            System.out.println("\t\tTelefono: " + agenda.get(pos).getTelefono());
            System.out.println("\t\tEmail: " + agenda.get(pos).getEmail());
            System.out.println("\t\tFecha Nac: " + agenda.get(pos).getFechaNac());
            System.out.println("\t\tRedes: " + agenda.get(pos).getRedSocial());
        }
    }

    private static void listarContactos() {
        for(Contacto c:agenda){
            System.out.println(c);
        }

        System.out.println("");

        agenda.stream().filter(c->c.getRedSocial().equalsIgnoreCase("facebook"))
                .sorted(Comparator.comparing(c->c.getNombre())).forEach(c->System.out.println(c));
    }

    private static void compararContactos() {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\n\nDiferencia de edad entre dos contactos");
        System.out.println("Dime el primer contacto que quieres comparar:");
        String nombre1=sc.nextLine();





    }
}