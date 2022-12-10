package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.POJO.Usuario;
import sistemabibliotecario.conexionBD.ConexionBD;
import sistemabibliotecario.utills.Constantes;


public class UsuarioDAO 
{
    public static Usuario iniciarSesion(String nombreUsuario, String contrasenaUsuario) throws SQLException
    {
        
        Usuario usuarioSesion = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null)
        {
            
            try
            {
                
                String consulta = "SELECT idUsuario, nombreUsuario FROM usuario "
                        + "WHERE nombreUsuario = ? AND contrasenaUsuario = ?";
                PreparedStatement consultaLogin = conexionBD.prepareCall(consulta);
                consultaLogin.setString(1, nombreUsuario);
                consultaLogin.setString(2, contrasenaUsuario);
                ResultSet resultadoConsulta = consultaLogin.executeQuery();
                usuarioSesion = new Usuario();
                if(resultadoConsulta.next())
                    {

                        usuarioSesion.setIdUsuario(resultadoConsulta.getInt("idUsuario"));
                        usuarioSesion.setNombreUsuario(resultadoConsulta.getString("nombreUsuario"));

                    }else
                    {

                        usuarioSesion.setIdUsuario(-1);

                    }
                
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
        }
        return usuarioSesion;
    }
}
