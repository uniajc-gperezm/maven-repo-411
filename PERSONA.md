# Diagrama de clase Persona codigo Mermaid

```mermaid
classDiagram
	class Persona {
		-String identificacion
		-String nombre
		-int edad
		-String correo
		+Persona()
		+Persona(String identificacion)
		+Persona(String id, String nombre, int edad, String correo)
		+void mostrarInformacion()
		+String getIdentificacion()
	}
```

# Diagrama de clases Persona codigo startuml

```plantuml
@startuml
class Persona {
	-String identificacion
	-String nombre
	-int edad
	-String correo
	+Persona()
	+Persona(String identificacion)
	+Persona(String id, String nombre, int edad, String correo)
	+void mostrarInformacion()
	+String getIdentificacion()
}
@enduml
```