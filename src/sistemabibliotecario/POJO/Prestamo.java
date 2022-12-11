package sistemabibliotecario.POJO;

public class Prestamo {
    private int idPrestamo;
    private String fecha;
    private int idRecurso;

    //CONSTRUCTOR
    public Prestamo() 
    {
    }
    public Prestamo(String fecha, int idRecurso) 
    {
        this.fecha = fecha;
        this.idRecurso = idRecurso;
    }

    //GETTERS
    public int getIdPrestamo() 
    {
        return idPrestamo;
    }
    public String getFecha() 
    {
        return fecha;
    }
    public int getIdRecurso() 
    {
        return idRecurso;
    }
    
    //SETTERS
    public void setIdPrestamo(int idPrestamo) 
    {
        this.idPrestamo = idPrestamo;
    }
    public void setFecha(String fecha) 
    {
        this.fecha = fecha;
    }
    public void setIdRecurso(int idRecurso) 
    {
        this.idRecurso = idRecurso;
    }
    
}
