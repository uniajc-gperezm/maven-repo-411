package com.uniajc;

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
        Persona persona3 = new Persona("987654321", "Juan Pérez", 30, "correo@mail.com");
        persona3.mostrarInformacion();

        // Crear un objeto de la clase Persona con fecha de nacimiento (20/05/1995)
        Persona persona4 = new Persona("555666777", "María Gómez", 0, "maria@mail.com", 20, 5, 1995);

        // Calcular la edad con la fecha actual (18/09/2026) y guardarla en el atributo edad
        int edadCalculada = persona4.calcularEdad(18, 9, 2026);
        persona4.setEdad(edadCalculada);
        persona4.mostrarInformacion();

        // Asignar la fecha de nacimiento con los setters (15/01/2000)
        persona2.setDiaNacimiento(15);
        persona2.setMesNacimiento(1);
        persona2.setAnioNacimiento(2000);
        persona2.setEdad(persona2.calcularEdad(18, 9, 2026));
        persona2.mostrarInformacion();

    }


}