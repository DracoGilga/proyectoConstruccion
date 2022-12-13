/*
 * POJO Recurso
 * Autor: Gonzalez Lopez Cesar
 * 11/12/2022
 * Descripción: Pojo de recurso para el registro de estos al sistema
 */
package sistemabibliotecario.POJO;

public class Recurso 
{
    
    private int idRecurso;
    private String titulo;
    private String editorial;
    private String autor;
    private String edicion;
    private String isbn;
    private int tomo;
    private String anio;
    private String estado;

    //CONSTRUCTORES
    public Recurso() {
    }

    public Recurso(int idRecurso, String titulo, String editorial, String autor, String edicion, String isbn, int tomo, String anio, String estado) {
        this.idRecurso = idRecurso;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.edicion = edicion;
        this.isbn = isbn;
        this.tomo = tomo;
        this.anio = anio;
        this.estado = estado;
    }

    //GETTERS

    public int getIdRecurso() {
        return idRecurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAutor() {
        return autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getTomo() {
        return tomo;
    }

    public String getAnio() {
        return anio;
    }

    public String getEstado() {
        return estado;
    }

    //SETTERS

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
