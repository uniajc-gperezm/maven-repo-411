package biblioteca;

public class Main {
    public static void main(String[] args) {

        // 1. Crear objeto libro 1 utilizando el constructor con parámetros
        Libro libro1 = new Libro("Java Avanzado", "Carlos Ruiz", 5, 1);

        // 2. Crear objeto libro 2 utilizando el constructor por defecto y obtener datos por consola
        Libro libro2 = new Libro();
        libro2.setTitulo("POO en Java");
        libro2.setAutor("María López");
        libro2.setNumeroEjemplares(4);
        libro2.setEjemplaresPrestados(1);

        System.out.println("Libro 2:");
        System.out.println(libro2);

        // 3. Crear objeto libroTextoUNIAC con todos sus atributos
        LibroTextoUNIAC libroTextoUNIAC = new LibroTextoUNIAC(
                "Estructuras de Datos",
                "Pedro Gómez",
                7,
                3,
                "Ingeniería de Sistemas",
                "Facultad de Ingeniería"
        );

        // 4. Crear un objeto novela indicando su tipo
        Novela novela = new Novela(
                "Cien años de soledad",
                "Gabriel García Márquez",
                3,
                1,
                "Realista"
        );

        System.out.println("\nLibroTextoUNIAC:");
        System.out.println(libroTextoUNIAC);

        System.out.println("\nNovela:");
        System.out.println(novela);

        // Probar los métodos de préstamo y devolución desde la clase Main
        System.out.println("\nPréstamo libro1: " + libro1.prestamo());
        System.out.println(libro1);

        System.out.println("\nDevolución libro1: " + libro1.devolucion());
        System.out.println(libro1);

        System.out.println("\nPréstamo novela: " + novela.prestamo());
        System.out.println(novela);

        System.out.println("\nDevolución novela: " + novela.devolucion());
        System.out.println(novela);
    }
}
