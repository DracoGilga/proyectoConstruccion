/*
 * POJO UsuarioBibliotecario
 * Autor: Álvaro Barradas Fernández
 * 10/12/2022
 * Descripción: Pojo de usuario bibliotecario para el registro de este al sistema
 */
package sistemabibliotecario.POJO;

public class UsuarioBibliotecario 
{
    
    private String idUsuarioBibliotecario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private int idRegion;
    private String region;
    private int idCarrera;
    private String carrera;
    
    //CONSTRUCTORES

    public UsuarioBibliotecario() {
    }

    public UsuarioBibliotecario(String idUsuarioBibliotecario, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, int idRegion, String region, int idCarrera, String carrera) {
        this.idUsuarioBibliotecario = idUsuarioBibliotecario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.idRegion = idRegion;
        this.region = region;
        this.idCarrera = idCarrera;
        this.carrera = carrera;
    }

    //GETTERS

    public String getIdUsuarioBibliotecario() {
        return idUsuarioBibliotecario;
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

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }
    
    //SETTERS

    public void setIdUsuarioBibliotecario(String idUsuarioBibliotecario) {
        this.idUsuarioBibliotecario = idUsuarioBibliotecario;
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

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
}
