package com.uniajc;

// Librerías para trabajar con fechas (ya vienen incluidas en Java)
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

    // Atributos de la clase Persona (son privados: solo se acceden con get y set)
    private String identificacion;
    private String nombre;
    private int edad;
    private String correo;

    // Atributo nuevo: la fecha de nacimiento de la persona.
    // Uso LocalDate porque guarda solo día, mes y año, y sirve para calcular la edad.
    private LocalDate fechaNacimiento;

    // Getters y Setters (encapsulamiento)
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

    // Getter y setter del atributo nuevo, igual que los demás
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Constructor vacío
    public Persona() {
    }

    // Constructor con un parámetro (solo la identificación)
    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    // Constructor con todos los parámetros.
    // No le agregué la fecha para no cambiar cómo se crea una Persona;
    // la fecha se asigna después con setFechaNacimiento().
    public Persona(String id, String nombre, int edad, String correo) {
        this.identificacion = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    // Método nuevo: calcula la edad usando la fecha de nacimiento.
    // ChronoUnit.YEARS.between cuenta los años completos entre la fecha de
    // nacimiento y la fecha de hoy (LocalDate.now()), por eso si todavía no
    // ha cumplido años este año, no lo cuenta.
    // Si la fecha es null devuelvo 0 para que el programa no se caiga.
    public int calcularEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    // Muestra la información de la persona en consola
    public void mostrarInformacion() {
        System.out.println("Información de la persona:");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Correo: " + correo);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Edad calculada: " + calcularEdad());
        System.out.println("-----------------------------");
    }
}
