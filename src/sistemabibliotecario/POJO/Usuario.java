
package sistemabibliotecario.POJO;

public class Usuario 
{
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenaUsuario;
    private int codigoRespuesta;
    
    //CONSTRUCTORES
    public Usuario() 
    {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasenaUsuario, int codigoRespuesta) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.codigoRespuesta = codigoRespuesta;
    }
    
    //GETTERS
    public int getIdUsuario() 
    {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    
    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    //SETTERS

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
    
}
