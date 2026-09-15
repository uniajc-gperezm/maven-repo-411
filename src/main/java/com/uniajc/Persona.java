package com.uniajc;

public class Persona {

    // Atributos de la clase Persona
    private String identificacion;
    private String nombre;
    private int edad;
    private String correo;
    
    // Constructor Vacio de la clase Persona 
    public Persona() {
    }
    
    // Constructor de la clase Persona con un parámetro
    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    // Constructor de la clase Persona con parámetros
    public Persona(String id, String nombre, int edad, String correo) {
        this.identificacion = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    // Metodos clase para mostrar información de la persona

    public void mostrarInformacion() {
        System.out.println("Información de la persona:");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Correo: " + correo);
        System.out.println("-----------------------------");

    }

    public String getIdentificacion() {
        return identificacion;
    }
    
}
