# demo-maven411

Proyecto de demostración con Maven, JUnit (Jupiter) y dependencia de MySQL configurada en el `pom.xml`.

## Tabla de contenido

- [Estructura de un proyecto Maven](#estructura-de-un-proyecto-maven)
- [Ciclo de vida de Maven](#ciclo-de-vida-de-maven)
- [Explicación del `pom.xml`](#explicación-del-pomxml)
- [Pruebas unitarias con JUnit](#pruebas-unitarias-con-junit)
- [Comandos útiles](#comandos-útiles)

## Estructura de un proyecto Maven

Maven impone una estructura estándar de directorios (conocida como *Standard Directory Layout*), lo que permite que cualquier desarrollador entienda el proyecto sin configuración adicional:

```
demo-maven411/
├── pom.xml                        # Archivo de configuración principal del proyecto
├── src/
│   ├── main/
│   │   ├── java/                  # Código fuente de la aplicación (producción)
│   │   │   └── com/uniajc/
│   │   │       └── Main.java
│   │   └── resources/             # Archivos de configuración, properties, imágenes, etc.
│   └── test/
│       └── java/                  # Código fuente de las pruebas unitarias
│           └── com/uniajc/
│               └── MainTest.java
└── target/                        # Carpeta generada por Maven (compilados, jar, reportes)
    ├── classes/                   # .class compilados de src/main/java
    └── test-classes/              # .class compilados de src/test/java
```

Puntos clave:

- **`src/main/java`**: contiene el código de producción, lo que finalmente se empaqueta en el `.jar`/`.war`.
- **`src/main/resources`**: archivos no Java que se incluyen en el paquete final (`application.properties`, XML, etc.).
- **`src/test/java`**: contiene las clases de prueba. Maven las compila y ejecuta, pero **no** las incluye en el artefacto final.
- **`target/`**: carpeta temporal/generada. No se versiona en Git (debe ir en `.gitignore`), ya que se recrea en cada build.

## Ciclo de vida de Maven

Maven organiza la construcción del proyecto en **ciclos de vida**, compuestos por **fases** que se ejecutan en orden. El ciclo de vida por defecto (`default`) es el más usado y contiene, entre otras, las siguientes fases:

| Fase          | Qué hace |
|---------------|----------|
| `validate`    | Verifica que el proyecto esté correcto y toda la información necesaria esté disponible. |
| `compile`     | Compila el código fuente de `src/main/java` y lo deja en `target/classes`. |
| `test`        | Compila y ejecuta las pruebas unitarias de `src/test/java` usando un framework de pruebas (JUnit, en este caso), a través del plugin `maven-surefire-plugin`. |
| `package`     | Empaqueta el código compilado en su formato distribuible (`.jar`, `.war`, etc.). |
| `verify`      | Ejecuta comprobaciones adicionales sobre los resultados de las pruebas de integración, para asegurar que el paquete cumple los criterios de calidad. |
| `install`     | Instala el paquete en el repositorio local de Maven (`~/.m2/repository`), para que otros proyectos locales puedan usarlo como dependencia. |
| `deploy`      | Copia el paquete final a un repositorio remoto, para compartirlo con otros desarrolladores o proyectos. |

Cada fase ejecuta automáticamente todas las fases anteriores. Por ejemplo, al correr:

```bash
mvn install
```

Maven ejecuta en orden: `validate → compile → test → package → verify → install`.

## Explicación del `pom.xml`

El `pom.xml` (**P**roject **O**bject **M**odel) es el archivo de configuración central de un proyecto Maven. Define identidad, dependencias, propiedades y plugins de construcción.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ...>
    <modelVersion>4.0.0</modelVersion>
```
- `modelVersion`: versión del esquema del POM que utiliza Maven (siempre `4.0.0` en versiones actuales).

```xml
    <groupId>com.uniajc</groupId>
    <artifactId>demo-maven411</artifactId>
    <version>1.0-SNAPSHOT</version>
```
Estas tres etiquetas forman las **coordenadas Maven**, que identifican de forma única al proyecto/artefacto en cualquier repositorio:
- `groupId`: identifica la organización o grupo (normalmente el dominio invertido, ej. `com.uniajc`).
- `artifactId`: nombre del proyecto/módulo.
- `version`: versión del artefacto. El sufijo `-SNAPSHOT` indica que es una versión en desarrollo (no estable/definitiva).

```xml
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>
```
- `properties`: valores reutilizables dentro del POM. Aquí se define la versión de Java usada para compilar (`source`) y la versión de bytecode generada (`target`), en este caso Java 17.

```xml
    <dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.3.0</version>
            <scope>compile</scope>
        </dependency>
        ...
    </dependencies>
```
- `dependencies`: lista de librerías externas que el proyecto necesita. Cada `dependency` se identifica con las mismas coordenadas `groupId`/`artifactId`/`version`.
- `scope`: define en qué momento del ciclo de vida está disponible la dependencia:
  - `compile` (por defecto): disponible en compilación, pruebas y ejecución. Ej. `mysql-connector-j`, que la aplicación necesita en tiempo de ejecución para conectarse a la base de datos.
  - `test`: disponible solo al compilar y ejecutar pruebas (no se incluye en el artefacto final). Ej. `junit-jupiter-api` y `junit-jupiter-engine`.

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.2</version>
            </plugin>
        </plugins>
    </build>
```
- `build`/`plugins`: configura los *plugins* que extienden el comportamiento de Maven. El **`maven-surefire-plugin`** es el encargado de ejecutar las pruebas unitarias durante la fase `test` y de reportar sus resultados.

## Pruebas unitarias con JUnit

### Dependencias necesarias

Para escribir y ejecutar pruebas con JUnit 5 (JUnit Jupiter) se necesitan dos dependencias con `scope test`:

- **`junit-jupiter-api`**: contiene las anotaciones y clases que se usan para *escribir* las pruebas (`@Test`, `Assertions`, etc.).
- **`junit-jupiter-engine`**: es el motor que *ejecuta* las pruebas escritas con la API anterior. Sin este engine, Maven compila las pruebas pero no las ejecuta.

Además, el **`maven-surefire-plugin`** es el puente entre Maven y el motor de JUnit: durante la fase `test`, Surefire descubre las clases de prueba (por convención, las que terminan en `Test`, `Tests`, `TestCase`) y las ejecuta.

### Estructura de una clase de prueba

Archivo: [MainTest.java](src/test/java/com/uniajc/MainTest.java)

```java
package com.uniajc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void sumarDosNumerosPositivos() {
        assertEquals(5, Main.sumar(2, 3));
    }
}
```

- **`@Test`**: marca un método como caso de prueba. Surefire ejecutará cada método anotado como una prueba independiente.
- **`assertEquals(esperado, actual)`**: método de aserción que compara el valor esperado contra el valor devuelto por el código bajo prueba. Si no coinciden, la prueba falla y Maven detiene el build (a menos que se configure lo contrario).
- **Convención de nombres**: los métodos de prueba deben tener nombres descriptivos de lo que validan (`sumarDosNumerosPositivos`, `sumarConCero`, `sumarDosNumerosNegativos`), ya que aparecen en el reporte de resultados.
- Cada prueba debe ser **independiente**: no debe depender del orden de ejecución ni del estado dejado por otra prueba.

### Cómo se relaciona con el código de producción

El método probado vive en [Main.java](src/main/java/com/uniajc/Main.java):

```java
public static int sumar(int a, int b) {
    return a + b;
}
```

Cada prueba llama al método real y valida su resultado con distintos casos (números positivos, cero, números negativos), cubriendo diferentes escenarios de entrada.

### Ejecutar las pruebas

```bash
mvn test
```

Esto compila `src/main/java` y `src/test/java`, y ejecuta todas las clases de prueba encontradas en `src/test/java`. Al final se muestra un resumen como:

```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

Si alguna aserción falla, Maven marca el build como **fallido** (`BUILD FAILURE`) y detiene las fases siguientes (`package`, `install`, etc.), evitando que código con errores llegue a producción.

## Comandos útiles

| Comando | Descripción |
|---|---|
| `mvn compile` | Compila solo el código de `src/main/java`. |
| `mvn test` | Compila y ejecuta las pruebas unitarias. |
| `mvn package` | Genera el `.jar` en `target/`. |
| `mvn clean` | Elimina la carpeta `target/`. |
| `mvn clean install` | Limpia, compila, prueba, empaqueta e instala el artefacto en el repositorio local. |

Lider de proyecto: Gabriel Perez
Integrante #1 Esneider Espitia
Integrante #2 Kevin García
Integrante #3 Angel Cuenu
