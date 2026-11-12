package org.example.agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AgendaEdu {
    private static ArrayList<Contacto> agenda=new ArrayList();


    public static void main(String[] args) {
        cargaDatos();
        menu();
    }

    public static void cargaDatos() {
        agenda.add(new Contacto("Ana", "666666000", "ana@hotmail.com ", LocalDate.parse("2006-12-05"),"facebook"));
        agenda.add(new Contacto("Pepe", "666666111", "pepe@hotmail.com", LocalDate.parse("2000-11-03"),"instagram"));
        agenda.add(new Contacto("Eva", "666666222", "eva@hotmail.com ", LocalDate.parse("1996-04-19"),"facebook"));
        agenda.add(new Contacto("Julia", "666666333", "julia@hotmail.com", LocalDate.parse("2000-04-19"),"instagram"));
        agenda.add(new Contacto("Luis", "666666444", "luis@hotmail.com", LocalDate.parse("2004-04-04"),"facebook"));
        agenda.add(new Contacto("Bea", "666666555", "bea@hotmail.com ", LocalDate.parse("2005-11-05"),"instagram"));
        agenda.add(new Contacto("Lucas", "666666666", "lucas@hotmail.com", LocalDate.parse("2006-12-02"),"TikTok"));
        agenda.add(new Contacto("Olivia", "666666777", "olivia@hotmail.com", LocalDate.parse("2007-11-05"),"TikTok"));
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
            System.out.println("\t\t\t4. MOSTRAR CONTACTO");
            System.out.println("\t\t\t5. LISTAR CONTACTOS");
            System.out.println("\t\t\t6. SALIR DE LA AGENDA");
            System.out.println("\n\nTeclea una opción:");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> añadirContacto();
                case 2 -> eliminarContacto();
                case 3 -> listadosStreams();
                case 4 -> muestraContacto();
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
        int pos=buscaContacto(nombre);
        if (pos==-1){
            System.out.println("Ese nombre no está en la agenda");
        }else{
            agenda.remove(pos);
            System.out.println("Contacto eliminado");
        }

    }

    private static void modificarContacto() {
        System.out.println("Está sin desarrollar. también puedes borrarlo y volver a crearlo con nuevos datos");
    }

    private static void muestraContacto() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Buscar Contacto:");
        System.out.print("Nombre:");
        String nombre=sc.nextLine();
        int pos=buscaContacto(nombre);
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

    /**
     * Método auxiliar para buscar un nombre en la agenda
     * @param nombre String
     * @return int posición del nombre en el ArrayList 0 -1 si no se encuentra
     */
    private static int buscaContacto(String nombre){
        int pos=-1;
        for (int i=0;i<agenda.size();i++){
            if(agenda.get(i).getNombre().equalsIgnoreCase(nombre)){
                pos=i;
                break;
            }
        }
        return pos;
    }

    private static void listarContactos() {

        //recorrido agenda con for tradicional
        for(int i=0;i<agenda.size();i++){
            System.out.println(agenda.get(i));
        }
        System.out.println("");

        //recorrido con For EACH - NO ADMITE MODIFICACIONES NI CONTROLA POSICIÓN
        for(Contacto c:agenda){
            System.out.println(c);
        }
        System.out.println("");

        //recorrido con API Streams - Programación funcional
        agenda.stream().forEach(c->System.out.println(c));
        //alternativamente podemos poner .forEach(System.out::println)


        //Cuántos contactos de la agenda tienen facebook y quienes son
        int contador=0;
        for(Contacto c:agenda){
            if(c.getRedSocial().equalsIgnoreCase("facebook")){
                contador++;
                System.out.println(c.getNombre());
            }
        }
        System.out.println("\nEn total " + contador + " contactos tiene facebook");


        //Clasificar contactos por su red Social recorriendo la agenda 1 sola vez
        //En el futuro todo los que sea clasificar --> groupingBy con API Stream

        ArrayList <Contacto> aFacebook=new ArrayList();
        ArrayList <Contacto> aInstagram=new ArrayList();
        ArrayList <Contacto> aTikTok=new ArrayList();
        for(Contacto c:agenda){
            if(c.getRedSocial().equalsIgnoreCase("facebook")){
                aFacebook.add(c);
            }
            if(c.getRedSocial().equalsIgnoreCase("instagram")){
                aInstagram.add(c);
            }
            if(c.getRedSocial().equalsIgnoreCase("tiktok")){
                aTikTok.add(c);
            }
        }
        System.out.println("los contactos de Facebook son " + aFacebook.size()+ " :" );
        for (Contacto c:aFacebook){
            System.out.println(c.getNombre());
        }
        System.out.println("los contactos de Instagram son " + aInstagram.size()+ " :" );
        for (Contacto c:aInstagram){
            System.out.println(c.getNombre());
        }
        System.out.println("los contactos de TikTok son " + aTikTok.size()+ " :" );
        for (Contacto c:aTikTok){
            System.out.println(c.getNombre());
        }


        //Listado de contactos que cumplen años hoy
        System.out.println("\n\nHoy cumplen años:");
        LocalDate hoy=LocalDate.now();
        for (Contacto c:agenda){
            if (c.getFechaNac().getDayOfMonth()==hoy.getDayOfMonth()
                    && c.getFechaNac().getMonthValue()==hoy.getMonthValue()){
                System.out.println(c.getNombre());
            }

        }

        //Diferencia de edad entre 2 contactos introducidos por teclado

        Scanner sc=new Scanner(System.in);
        System.out.println("\n\nDiferencia de edad entre 2 contactos:");
        System.out.print("Nombre1:");
        String nombre1=sc.nextLine();
        int pos1=buscaContacto(nombre1);
        System.out.print("Nombre2:");
        String nombre2=sc.nextLine();
        int pos2=buscaContacto(nombre2);
        LocalDate fechaNac1=agenda.get(pos1).getFechaNac(); //Fecha nacimiento nombre1
        LocalDate fechaNac2=agenda.get(pos2).getFechaNac(); //Fecha nacimiento nombre2
        /* la clase ChronoUnit tiene un método muy interesante para calcular los días
        de diferencia entre 2 fechas LocalDate
        Le aplico el metodo Math.abs para que no me de resultado negativo y
        después los días de diferencia los paso a años + días restantes
        */
        long diasEntre= Math.abs(ChronoUnit.DAYS.between(fechaNac1,fechaNac2));

        int bisiestos=0;
        for (int i=fechaNac1.getYear();i<fechaNac2.getYear();i++){
            if (LocalDate.parse(String.valueOf(i)+"-01-01").isLeapYear()){
                bisiestos++;
            }
        }

        System.out.println(bisiestos);


        int anios=(int)diasEntre/365;
        int dias=(int)diasEntre%365;
        //Con .isBefore puedo saber que contacto nació antes (Es mayor)
        if (fechaNac1.isBefore(fechaNac2)){
            System.out.println(nombre1 + " es mayor que " + nombre2);
            System.out.println("Se llevan: " + anios + " años y " + dias + " dias" );
        }else{
            System.out.println(nombre2 + " es mayor que " + nombre1);
            System.out.println("Se llevan: " + anios + " años y " + dias + " dias" );
        }

        //Listado mostrando las Edades de mis contactos
        System.out.println("\n\nEdades de mis contactos:");
        hoy=LocalDate.now();
        int edad;
        for (Contacto c:agenda){
            edad=hoy.getYear()-c.getFechaNac().getYear();
            if(hoy.getDayOfYear()>=c.getFechaNac().getDayOfYear()){
                System.out.println(c.getNombre() + " tiene " + edad + " años");
            }else{
                System.out.println(c.getNombre() + " tiene " + (edad-1) + " años");
            }
        }
    }

    private static void listadosStreams(){
        //Ejemplo de listado de contactos ordenados por fecha de nacimiento usando el API de Stream
        if (LocalDate.now().getDayOfMonth()==1){
            agenda.stream()
                    .filter(c->c.getFechaNac().getMonthValue()==LocalDate.now().getMonthValue())
                    .sorted(Comparator.comparing(Contacto::getFechaNac))
                    .forEach(System.out::println);
        }
    }

    private static void comparacionEdad () {
        Scanner sc =  new Scanner(System.in);
        
    }
}