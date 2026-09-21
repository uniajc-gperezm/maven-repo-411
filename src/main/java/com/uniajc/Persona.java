package com.uniajc;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    // Atributos de la clase Persona
    // Abstracción de los atributos de la clase Persona
    private String identificacion;
    private String nombre;
    //private int edad;
    private String correo;
    private LocalDate fechaNacimiento;
    
    
    // Getters y Setters de los atributos de la clase Persona
    // Encapsulamiento de los atributos de la clase Persona

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public int getEdad() {
        return edad;
    }*/

    /*public void setEdad(int edad) {
        this.edad = edad;
    }*/

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        if (fechaNacimiento == null) {
            throw new IllegalStateException("La fecha de nacimiento no ha sido establecida");
        }

        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Constructor Vacio de la clase Persona 
    public Persona() {
    }
    
    // Constructor de la clase Persona con un parámetro
    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    // Constructor de la clase Persona con parámetros
    public Persona(String id, String nombre, LocalDate fechaNacimiento, String correo) {
        this.identificacion = id;
        this.nombre = nombre;
        //this.edad = edad;
        this.fechaNacimiento = fechaNacimiento; // Establecer la fecha de nacimiento a partir de la edad
        this.correo = correo;
    }

    // Metodos clase para mostrar información de la persona

    public void mostrarInformacion() {
        System.out.println("Información de la persona:");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        //System.out.println("Edad: " + edad);
        
        System.out.println("Correo: " + correo);
        System.out.println("-----------------------------");
    }
    
}
