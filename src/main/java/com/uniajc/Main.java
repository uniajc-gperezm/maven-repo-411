package com.uniajc;

public class Main {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello world desde grupo 411!");
        System.out.println("La suma de -2 y -6 es: " + sumar(-2, -6));

        persona1 p = new persona1("Juan", 22, "estudiante");
        System.out.println(p.describir());
    }
}