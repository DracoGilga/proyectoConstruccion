/*
 *
 * 
 */
package sistemabibliotecario.POJO;

public class Estudiante 
{
    
    private int idEstudiante;
    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private int idCarrera;
    private String carrera;
    private int idRegion;
    private String region;
    
    
    //CONSTRUCTORES

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, int idCarrera, String carrera, int idRegion, String region) {
        this.idEstudiante = idEstudiante;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.idRegion = idRegion;
        this.region = region;
    }
    

    //GETTERS
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getMatricula() {
        return matricula;
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

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getRegion() {
        return region;
    }

    //SETTERS

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
    
}
