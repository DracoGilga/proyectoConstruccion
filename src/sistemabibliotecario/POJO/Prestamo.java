/*
 * POJO prestamo
 * Autor: Gonzalez Lopez Cesar
 * 10/12/2022
 * Modificación: 11/12/2022, Álvaro Barradas Fernández
 * Descripción: Pojo de prestamo para el registro y solicitud de renovaciones de prestamos en el sistema
 */
package sistemabibliotecario.POJO;



public class Prestamo 
{
    
    private int idPrestamoSala;
    private int idPrestamoDomicilio;
    private String fechaInicio;
    private String fechaFin;
    private String fechaPrestamo;
    private int idRecurso;
    private String idUsuarioBibliotecario;

    //CONSTRUCTORER
    public Prestamo() 
    {
    }

    public Prestamo(int idPrestamoSala, int idPrestamoDomicilio, String fechaInicio, String fechaFin, String fechaPrestamo, int idRecurso, String idUsuarioBibliotecario) {
        this.idPrestamoSala = idPrestamoSala;
        this.idPrestamoDomicilio = idPrestamoDomicilio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaPrestamo = fechaPrestamo;
        this.idRecurso = idRecurso;
        this.idUsuarioBibliotecario = idUsuarioBibliotecario;
    }

    //GETTERS

    public int getIdPrestamoSala() {
        return idPrestamoSala;
    }

    public int getIdPrestamoDomicilio() {
        return idPrestamoDomicilio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public String getIdUsuarioBibliotecario() {
        return idUsuarioBibliotecario;
    }
    
    //SETTERS

    public void setIdPrestamoSala(int idPrestamoSala) {
        this.idPrestamoSala = idPrestamoSala;
    }

    public void setIdPrestamoDomicilio(int idPrestamoDomicilio) {
        this.idPrestamoDomicilio = idPrestamoDomicilio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public void setIdUsuarioBibliotecario(String idUsuarioBibliotecario) {
        this.idUsuarioBibliotecario = idUsuarioBibliotecario;
    }
    
    @Override
    public String toString()
    {
        
        return "Id del prestamo: " +idPrestamoDomicilio;
        
    }
    
}
