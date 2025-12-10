package module;

import java.time.LocalDate;

public abstract class RecursoDigital {
    protected String titulo;
    protected String autor;
    protected LocalDate fechaPublicacion;
    
    public RecursoDigital(String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public abstract void mostrarInformacionCompleta();

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
}