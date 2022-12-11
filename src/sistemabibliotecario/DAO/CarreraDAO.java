/*
 *
 *
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemabibliotecario.POJO.Carrera;
import sistemabibliotecario.conexionBD.ConexionBD;

public class CarreraDAO 
{
    
    public static ArrayList<Carrera> obtenerCarreras() throws SQLException
    {
        
        ArrayList<Carrera> carreras = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null)
        {
            
            try
            {
                
               String consulta = "SELECT idCarrera, nombre FROM carrera";
               PreparedStatement preparedStatement = conexionBD.prepareStatement(consulta);
               ResultSet resultSet = preparedStatement.executeQuery();
               carreras = new ArrayList<>();
               while(resultSet.next())
               {
                   
                   Carrera carreraNueva = new Carrera();
                   carreraNueva.setIdCarrera(resultSet.getInt("idCarrera"));
                   carreraNueva.setNombre(resultSet.getString("nombre"));
                   carreras.add(carreraNueva);
                   
               }
                
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        }
        
        return carreras;
        
    }
    
}
