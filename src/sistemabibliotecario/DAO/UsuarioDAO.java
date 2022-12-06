
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.conexionBD.ConexionBD;


public class UsuarioDAO 
{
    public static void probarConeccion() throws SQLException{
        Connection conexionBD = ConexionBD.abrirConeccionBD();
        try{
                String consulta = "INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `contrasenaUsuario`) VALUES (NULL, 'DracoG', '123')";
                PreparedStatement preparedStatement = conexionBD.prepareStatement(consulta);
                int resultset =preparedStatement.executeUpdate();     
            
        }catch(SQLException ex){
                ex.printStackTrace();
        }finally{
                conexionBD.close();
         }
        
    }
}
