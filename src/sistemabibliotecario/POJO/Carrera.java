/*
 * 
 * 
 */
package sistemabibliotecario.POJO;

public class Carrera 
{
    
    private int idCarrera;
    private String nombre;
    
    //CONSTRUCTORES

    public Carrera() {
    }

    public Carrera(int idCarrera, String nombre) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
    }
    
    
    //GETTERS
    public int getIdCarrera() {
        return idCarrera;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    //SETTERS
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    
    @Override
    public String toString()
    {
        
        return nombre;
        
    }
    
}
