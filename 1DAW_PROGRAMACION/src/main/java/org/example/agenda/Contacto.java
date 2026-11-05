package org.example.agenda;

import java.time.LocalDate;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNac;
    private String redSocial;

    public Contacto(String nombre, String telefono, String email, LocalDate fechaNac, String redSocial) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.redSocial = redSocial;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getRedSocial() {
        return redSocial;
    }
    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    @Override
    public String toString() {
        return nombre + "-" + telefono + "-" + email + "-" + fechaNac + "-" + redSocial;
    }
}
