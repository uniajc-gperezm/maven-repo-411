package biblioteca;

public class Novela extends Libro {
    private String tipo;

    public Novela() {
        super();
        this.tipo = "";
    }

    public Novela(String titulo, String autor, int numeroEjemplares,
            int ejemplaresPrestados, String tipo) {
        super(titulo, autor, numeroEjemplares, ejemplaresPrestados);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Novela{" +
            "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
            ", numeroEjemplares=" + getNumeroEjemplares() +
            ", ejemplaresPrestados=" + getEjemplaresPrestados() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
