/*
 * POJO Usuario
 * Autor: Álvaro Barradas Fernández
 * 09/12/2022
 * Descripción: Pojo de usuario para el inicio de sesion al sistema
 */
package sistemabibliotecario.POJO;

public class Usuario 
{
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenaUsuario;
    
    //CONSTRUCTORES
    public Usuario() 
    {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
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

    //modificacion
}
