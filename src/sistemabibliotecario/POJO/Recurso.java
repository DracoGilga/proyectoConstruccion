/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.POJO;

/**
 *
 * @author hp
 */
public class Recurso 
{
    private int idRecurso ;
    private String titulo ;
    private String editor ;
    private String autor ;
    private String tema ;
    private String ISBN ;
    private String serie ;
    private String asignatura ;
    private String anio ;
    private String estado ;
    private int numDisponible ;
    
    //CONSTRUCTORES

    public Recurso() 
    {
    }
    public Recurso(String titulo, String editor, String autor, String tema, String ISBN, String serie, String asignatura, String danio, String estado, int numDisponible) 
    {
        this.titulo = titulo;
        this.editor = editor;
        this.autor = autor;
        this.tema = tema;
        this.ISBN = ISBN;
        this.serie = serie;
        this.asignatura = asignatura;
        this.anio = danio;
        this.estado = estado;
        this.numDisponible = numDisponible;
    }

    public Recurso(String titulo, String editor, String autor, String ISBN, String serie, String estado, int numDisponible,String danio) {
        this.titulo = titulo;
         this.editor = editor;
        this.autor = autor;
        this.ISBN = ISBN;
        this.serie = serie;
        this.estado = estado;
        this.numDisponible = numDisponible;
        this.anio = danio;
    }
    
    
    //SETTERS
    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }
    public void setEditor(String editor) 
    {
        this.editor = editor;
    }
    public void setAutor(String autor) 
    {
        this.autor = autor;
    }
    public void setTema(String tema) 
    {
        this.tema = tema;
    }
    public void setISBN(String ISBN) 
    {
        this.ISBN = ISBN;
    }
    public void setSerie(String serie) 
    {
        this.serie = serie;
    }
    public void setAsignatura(String asignatura) 
    {
        this.asignatura = asignatura;
    }
    public void setAnio(String anio) 
    {
        this.anio = anio;
    }
    public void setEstado(String estado) 
    {
        this.estado = estado;
    }
    public void setNumDisponible(int numDisponible) 
    {
        this.numDisponible = numDisponible;
    }
    public void setIdRecurso(int idRecurso) 
    {
        this.idRecurso = idRecurso;
    }
    
    //GETTERS
    public int getIdRecurso() 
    {
        return idRecurso;
    }
    public String getTitulo() 
    {
        return titulo;
    }
    public String getEditor() 
    {
        return editor;
    }
    public String getAutor() 
    {
        return autor;
    }
    public String getTema() 
    {
        return tema;
    }
    public String getISBN() 
    {
        return ISBN;
    }
    public String getSerie() 
    {
        return serie;
    }
    public String getAsignatura() 
    {
        return asignatura;
    }
    public String getAnio() 
    {
        return anio;
    }
    public String getEstado() 
    {
        return estado;
    }
    public int getNumDisponible() 
    {
        return numDisponible;
    }
    
}
