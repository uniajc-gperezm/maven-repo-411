package com.uniajc;

public class persona1 {
    private String nombre;
    private int edad;
    private String profesion;

    public persona1(String nombre, int edad, String profesion) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    public String describir() {
        return "Hola, mi nombre es " + nombre + ", tengo " + edad + " años y soy " + profesion + ".";
    }
}
