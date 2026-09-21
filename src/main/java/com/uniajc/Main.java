package com.uniajc;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Crear un objeto de la clase Persona
        Persona persona1 = new Persona();
        persona1.mostrarInformacion();

        // Crear un objeto de la clase Persona con un parámetro
        Persona persona2 = new Persona("123456789");
        persona2.mostrarInformacion();

        persona2.setIdentificacion("324234");
        persona2.getIdentificacion();

        // Crear un objeto de la clase Persona con parámetros
        Persona persona3 = new Persona("987654321", "Juan Pérez",
         LocalDate.of(2001, 6, 15), "correo@mail.com");

        //persona3.setEdad(persona3.calcularEdad());
        persona3.mostrarInformacion();
        System.out.println("Edad calculada a partir de la fecha de nacimiento: " + persona3.calcularEdad());

    }


}