package biblioteca;

public class LibroTextoUNIAC extends LibroTexto {
    private String facultad;

    public LibroTextoUNIAC() {
        super();
        this.facultad = "";
    }

    public LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares,
                           int ejemplaresPrestados, String curso, String facultad) {
        super(titulo, autor, numeroEjemplares, ejemplaresPrestados, curso);
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "LibroTextoUNIAC{" +
            "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
            ", numeroEjemplares=" + getNumeroEjemplares() +
            ", ejemplaresPrestados=" + getEjemplaresPrestados() +
            ", curso='" + getCurso() + '\'' +
                ", facultad='" + facultad + '\'' +
                '}';
    }
}
