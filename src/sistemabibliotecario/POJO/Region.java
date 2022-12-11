/*
 * 
 * 
 */
package sistemabibliotecario.POJO;

public class Region 
{
    
    private int idRegion;
    private String nombre;
    
    //CONSTRUCTORES

    public Region() {
    }

    public Region(int idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    //GETTERS
    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    //SETTERS
    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
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
