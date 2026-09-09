package com.uniajc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void sumarDosNumerosPositivos() {
        assertEquals(5, Main.sumar(2, 3));
    }

    @Test
    void sumarConCero() {
        assertEquals(4, Main.sumar(4, 0));
    }

    @Test 
    void sumarDosNumerosNegativos() {
        assertEquals(-8, Main.sumar(-5, -3));
    }
}
