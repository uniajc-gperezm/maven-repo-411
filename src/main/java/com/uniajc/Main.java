package com.uniajc;

public class Main {

    public static void main(String[] args) {

        // Crear un objeto de la clase Persona
        Persona persona1 = new Persona();
        persona1.mostrarInformacion();

        // Crear un objeto de la clase Persona con un parámetro
        Persona persona2 = new Persona("123456789");
        persona2.mostrarInformacion();

        // Crear un objeto de la clase Persona con parámetros
        Persona persona3 = new Persona("987654321", "Juan Pérez", 30, "correo@mail.com");
        persona3.mostrarInformacion();

    }


}