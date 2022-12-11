/*
 * 
 * 
 */
package sistemabibliotecario.POJO;

public class Docente 
{
    
    private int idDocente;
    private String numeroPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private int idRegion;
    private String region;
    
    //CONSTRUCTORES

    public Docente() {
    }

    public Docente(int idDocente, String numeroPersonal, String nombre, String apellidoPaterno, String apeelidoMaterno, String direccion, int idRegion, String region) {
        this.idDocente = idDocente;
        this.numeroPersonal = numeroPersonal;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apeelidoMaterno;
        this.direccion = direccion;
        this.idRegion = idRegion;
        this.region = region;
    }
    
    //GETTERS

    public int getIdDocente() {
        return idDocente;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getRegion() {
        return region;
    }
    
    //SETTER

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
