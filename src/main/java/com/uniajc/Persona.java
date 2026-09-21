package com.uniajc; // Asegúrate de mantener el paquete si tu IDE lo generó arriba

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    // Atributos de la clase Persona
    private String identificacion;
    private String nombre;
    private int edad; 
    private String correo;
    private LocalDate fechaNacimiento; // Nuevo atributo de fecha de nacimiento
    
    // Constructor Vacio de la clase Persona 
    public Persona() {
    }
    
    // Constructor de la clase Persona con un parámetro
    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    // Constructor de la clase Persona con parámetros originales
    public Persona(String id, String nombre, int edad, String correo) {
        this.identificacion = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    // Nuevo Constructor que incluye la fecha de nacimiento
    public Persona(String id, String nombre, String correo, LocalDate fechaNacimiento) {
        this.identificacion = id;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad(); // Calcula la edad automáticamente al crear la persona
    }

    // Getters y Setters de los atributos de la clase Persona

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

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
        this.edad = calcularEdad(); // Si cambian la fecha de nacimiento, se actualiza la edad
    }

    // Método nuevo para calcular la edad
    public int calcularEdad() {
        if (this.fechaNacimiento != null) {
            return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
        } else {
            return this.edad; // Retorna la edad manual si no hay fecha de nacimiento registrada
        }
    }

    // Método para mostrar información de la persona actualizado
    public void mostrarInformacion() {
        System.out.println("Información de la persona:");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Edad calculada: " + calcularEdad());
        System.out.println("Correo: " + correo);
        System.out.println("-----------------------------");
    }
    
}
