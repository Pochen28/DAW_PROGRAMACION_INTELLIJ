package org.example.agenda;

import java.time.LocalDate;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechayhora;
    private String redSocial;



    public Contacto(String nombre, String telefono,  String email, LocalDate fechayhora, String redSocial) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.email = email;
        this.fechayhora = fechayhora;
        this.redSocial = redSocial;
        Contacto C1 = new Contacto("Manuel", "623678627", "manuelillo@gmail.com", getFechayhora(), "manueloriginal");
    }


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechayhora() {
        return fechayhora;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechayhora(LocalDate fechayhora) {
        this.fechayhora = fechayhora;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechayhora=" + fechayhora +
                ", redSocial='" + redSocial + '\'' +
                '}';
    }
}
