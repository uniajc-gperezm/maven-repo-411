package biblioteca;

public class LibroTexto extends Libro {
    private String curso;

    public LibroTexto() {
        super();
        this.curso = "";
    }

    public LibroTexto(String titulo, String autor, int numeroEjemplares,
                      int ejemplaresPrestados, String curso) {
        super(titulo, autor, numeroEjemplares, ejemplaresPrestados);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "LibroTexto{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", numeroEjemplares=" + getNumeroEjemplares() +
                ", ejemplaresPrestados=" + getEjemplaresPrestados() +
                ", curso='" + curso + '\'' +
                '}';
    }
}