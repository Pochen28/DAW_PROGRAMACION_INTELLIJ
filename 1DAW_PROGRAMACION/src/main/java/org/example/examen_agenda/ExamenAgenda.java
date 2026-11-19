package org.example.examen_agenda;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class ExamenAgenda {
    private static ArrayList <Contacto> agenda=new ArrayList();


    public static void main(String[] args) {
        cargaDatos();
        ejercicio4();
        menu();

        listadosStreams();
    }

    public static void cargaDatos() {
        agenda.add(new Contacto("Ana", "666666000", "ana@hotmail.com ", LocalDate.parse("2000-01-01"),"familia"));
        agenda.add(new Contacto("Pepe", "666666111", "pepe@hotmail.com", LocalDate.parse("2003-08-11"),"familia"));
        agenda.add(new Contacto("Eva", "666666222", "eva@hotmail.com ", LocalDate.parse("1996-11-19"),"familia"));
        agenda.add(new Contacto("Julia", "666666333", "julia@hotmail.com", LocalDate.parse("2000-11-19"),"estudios"));
        agenda.add(new Contacto("Luis", "666666444", "luis@hotmail.com", LocalDate.parse("2004-04-04"),"estudios"));
        agenda.add(new Contacto("Bea", "666666555", "bea@hotmail.com ", LocalDate.parse("2005-11-09"),"ocio"));
        agenda.add(new Contacto("Lucas", "666666666", "lucas@hotmail.com", LocalDate.parse("2006-11-19"),"ocio"));
        agenda.add(new Contacto("Olivia", "666666777", "olivia@hotmail.com", LocalDate.parse("2007-11-19"),"deporte"));
        agenda.add(new Contacto("Tomas", "666666888", "tomas@hotmail.com", LocalDate.parse("2008-12-02"),"deporte"));
        agenda.add(new Contacto("Marta", "666666999", "marta@hotmail.com", LocalDate.parse("2009-11-27"),"deporte"));
    }

    private static void ejercicio1 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 1");
        System.out.println("\tDime el grupo de los contactos que quieres que se muestre (familia, estudios, deporte, ocio): ");
        String grupo = sc.nextLine();
        int contador = 0;
        for (Contacto c : agenda ) {
            if (c.getGrupo().equals(grupo)) {
                System.out.println(c.getNombre());
                contador++;
            }
        }
        if (contador != 0) {
            System.out.println("Hay " + contador + " contactos en el grupo " + grupo + ".");
        }else {
            System.out.println("No se ha encontrado ningún contacto del grupo especificado.");
        }
    }

    private static void ejercicio2 () {
        Scanner sc = new Scanner(System.in);
        LocalDate hoy = LocalDate.now();
        boolean cumpleHoy = false;
        System.out.println("Ejercicio 2");
        System.out.println("\tIntroduce un grupo para comprobar si algún contacto de este cumple años hoy:");
        String grupo = sc.nextLine();
        for (Contacto c : agenda ) {
            if (c.getGrupo().equalsIgnoreCase(grupo)
                    && c.getFechaNac().getMonthValue() == hoy.getMonthValue()
                    && c.getFechaNac().getDayOfMonth() == hoy.getDayOfMonth()) {
                System.out.println("Hoy cumple años " + c.getNombre() + ".");
                cumpleHoy = true;
            }
        }
        if (!cumpleHoy) {
            System.out.println("Ninguna persona del grupo especificado cumple años hoy.");
        }
    }

    private static void ejercicio3 () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicio 3");
        System.out.println("\tIntroduce un grupo para borrar todos sus contactos:");
        String grupo = sc.nextLine();
        String confirmar = "";
        ArrayList<Contacto> borrar = new ArrayList<>();
        for (Contacto c : agenda ) {
            if (c.getGrupo().equalsIgnoreCase(grupo)) {
                borrar.add(c);
            }
        }
        System.out.println("Vas a eliminar todos los contactos del grupo " + grupo + ", ¿confirmar?(si/no)" );
        confirmar = sc.nextLine();
        if (!confirmar.equalsIgnoreCase("si")) {
            System.out.println("Borrado cancelado exitosamente.");
            return;
        }
        agenda.removeAll(borrar);
        System.out.println("Se han borrado todos los contactos del grupo " + grupo + ".");
    }

    private static void ejercicio4 () {
        String [] grupos = {"Familia", "Estudios", "Deporte", "Ocio"};
        System.out.println("Ejercicio 4");
        int personas;
        for (String grupo : grupos) {
            personas = 0;
            for (Contacto c : agenda ) {
                if (c.getGrupo().equalsIgnoreCase(grupo)) {
                    personas++;
                }
            }
            if (personas != 0) {
                System.out.println("\t" + grupo + ":  " + personas);
            }else {
                System.out.println("\tNo existen contactos en el grupo " + grupo);
            }
        }
    }




    private static void listarContactos() {

        //recorrido agenda con for tradicional
        for(int i=0;i<agenda.size();i++){
            System.out.println(agenda.get(i));
        }
        System.out.println("");

        /* recorrido con For EACH - NO ADMITE MODIFICACIONES NI CONTROLA POSICIÓN
        for(Contacto c:agenda){
           System.out.println(c);
        }
        System.out.println("");

        recorrido con API Streams - Programación funcional
        agenda.stream().forEach(c->System.out.println(c));
        alternativamente podemos poner .forEach(System.out::println)
        */

        //Cuántos contactos de la agenda tienen facebook y quienes son
        int contador=0;
        for(Contacto c:agenda){
            if(c.getGrupo().equalsIgnoreCase("facebook")){
                contador++;
                System.out.println(c.getNombre());
            }
        }
        System.out.println("\nEn total " + contador + " contactos tiene facebook");


        //Listado de contactos que cumplen años hoy
        System.out.println("\n\nHoy cumplen años:");
        LocalDate hoy=LocalDate.now();
        for (Contacto c:agenda){
            if (c.getFechaNac().getDayOfMonth()==hoy.getDayOfMonth() &&
                    c.getFechaNac().getMonthValue()==hoy.getMonthValue()){
                System.out.println("Felicidades " + c.getNombre());
            }
        }

        //Diferencia de edad y saber cuál es mayor entre 2 contactos introducidos por teclado
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

        //AVERIGUAR CUAL DE LOS/AS 2 ES MAYOR o SI NACIERON EL MISMO DÍA

        //condicionales independientes
        if (fechaNac1.isBefore(fechaNac2)){
            System.out.println(nombre1 + " es mayor que " + nombre2);
        }
        if (fechaNac2.isBefore(fechaNac1)){
            System.out.println(nombre2 + " es mayor que " + nombre1);
        }
        if (fechaNac1.isEqual(fechaNac2)){
            System.out.println(nombre1 + " y " + nombre2 + " nacieron el mismo día");
        }

        //Con condicionales anidadas
        if (fechaNac1.isBefore(fechaNac2)){
            System.out.println(nombre1 + " es mayor que " + nombre2);
        } else if (fechaNac2.isBefore(fechaNac1)){
            System.out.println(nombre2 + " es mayor que " + nombre1);
        }else{
            System.out.println(nombre1 + " y " + nombre2 + " nacieron el mismo día");
        }

        /* las clases ChronoUnit y Period de Java tienen métodos muy interesante para calcular los días/años/meses ...
        de diferencia entre 2 fechas LocalDate
        Vamos a usar Period para calcular la diferencia de edad entre los 2 contactos
        en años, meses y días

        Para calcular de forma independiente diferencias entre fechas en días, meses y años
           ChronoUnit.DAYS.between(fecha1, fecha2);
           ChronoUnit.MONTHS.between(fecha1, fecha2);
           ChronoUnit.YEARS.between(fecha1, fecha2)

        */

        Period diferenciaEdad = Period.between(fechaNac1, fechaNac2);

        System.out.println("Años: " + diferenciaEdad.getYears());
        System.out.println("Meses: " + diferenciaEdad.getMonths());
        System.out.println("Días: " + diferenciaEdad.getDays());

        /*Por si fuera necesario, código para calcular cuantos
        años bisiestos hay entre 2 fechas */

        int bisiestos=0;
        for (int i=fechaNac1.getYear();i<fechaNac2.getYear();i++){
            if (LocalDate.parse(String.valueOf(i)+"-01-01").isLeapYear()){
                bisiestos++;
            }
        }

        //Listado mostrando las Edades (sólo en años) de mis contactos
        System.out.println("\n\nEdades de mis contactos:");
        hoy=LocalDate.now();
        long edad;
        for (Contacto c:agenda){
            edad=ChronoUnit.YEARS.between(c.getFechaNac(), hoy);
            System.out.println(c.getNombre()+ ": " + edad);
        }
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
                case 3 -> modificarContacto();
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
        ArrayList <Contacto> aux=new ArrayList();
        String nombre;
        System.out.println("Borrado de contactos");
        System.out.print("Nombre (FIN para terminar):");
        nombre=sc.nextLine();
        while (!nombre.equalsIgnoreCase("fin")){
            int pos=buscaContacto(nombre);
            if (pos==-1){
                System.out.println("Ese nombre no está en la agenda");
            }else{
                aux.add(agenda.get(pos));
                System.out.println(agenda.get(pos).getNombre() + " marcado/a para borrar");
            }
            System.out.print("Nombre (FIN para terminar):");
            nombre=sc.nextLine();
        }
        agenda.removeAll(aux);
        System.out.println("Se ha/n borrado " + aux.size() + " contacto/s");

        //Ejemplo de uso de removeIf para borrar los elementos de una colección que cumplen una condicion
        System.out.println("Teclea la red social para eliminar todos sus contactos:");
        String redSocial=sc.next();

        agenda.removeIf(c-> c.getGrupo().equalsIgnoreCase(redSocial));

        //Listado simple de la agenda para ver como queda despues de los borrados
        agenda.stream().forEach(c->System.out.println(c));
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
            System.out.println("\t\tRedes: " + agenda.get(pos).getGrupo());
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



    private static void listadosStreams(){
        //Ejemplo de listado de contactos ordenados por fecha de nacimiento usando el API de Stream
        agenda.stream()
                .sorted(Comparator.comparing(Contacto::getFechaNac))
                .forEach(System.out::println);

        //listado de contactos que tiene facebook ordenados por fecha denacimiento
        System.out.println("");
        agenda.stream()
                .filter(c->c.getGrupo().equalsIgnoreCase("facebook"))
                .sorted(Comparator.comparing(Contacto::getFechaNac))
                .forEach(System.out::println);
    }
}