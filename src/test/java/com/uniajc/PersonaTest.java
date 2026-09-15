package com.uniajc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class PersonaTest {

	@Test
	void constructorVacioInicializaLaIdentificacionEnNull() {
		Persona persona = new Persona();

		assertNull(persona.getIdentificacion());
	}

	@Test
	void constructorConIdentificacionGuardaLaIdentificacion() {
		Persona persona = new Persona("123456789");

		assertEquals("123456789", persona.getIdentificacion());
	}

	@Test
	void constructorCompletoGuardaLaIdentificacion() {
		Persona persona = new Persona("987654321", "Juan Perez", 30, "correo@mail.com");

		assertEquals("987654321", persona.getIdentificacion());
	}

	@Test
	void mostrarInformacionImprimeLosDatosDeLaPersona() {
		Persona persona = new Persona("987654321", "Juan Perez", 30, "correo@mail.com");
		PrintStream salidaOriginal = System.out;
		ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();

		try {
			System.setOut(new PrintStream(salidaCapturada));

			persona.mostrarInformacion();
		} finally {
			System.setOut(salidaOriginal);
		}

		String salida = salidaCapturada.toString();
		assertTrue(salida.contains("Identificación: 987654321"));
		assertTrue(salida.contains("Nombre: Juan Perez"));
		assertTrue(salida.contains("Edad: 30"));
		assertTrue(salida.contains("Correo: correo@mail.com"));
	}
}
