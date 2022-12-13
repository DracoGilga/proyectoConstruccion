/*
 * DAO Region
 * Autor: Álvaro Barradas Fernández
 * 10/12/2022
 * Descripción: Dao de region para el registro de docentes y estudiantes al sistema
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemabibliotecario.POJO.Region;
import sistemabibliotecario.conexionBD.ConexionBD;

public class RegionDAO 
{
    
    public static ArrayList<Region> obtenerRegiones() throws SQLException
    {
        
        ArrayList<Region> regiones = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null)
        {
            
            try
            {
                
               String consulta = "SELECT idRegion, nombre FROM region";
               PreparedStatement preparedStatement = conexionBD.prepareStatement(consulta);
               ResultSet resultSet = preparedStatement.executeQuery();
               regiones = new ArrayList<>();
               while(resultSet.next())
               {
                   
                   Region regionNueva = new Region();
                   regionNueva.setIdRegion(resultSet.getInt("idRegion"));
                   regionNueva.setNombre(resultSet.getString("nombre"));
                   regiones.add(regionNueva);
                   
               }
                
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        }
        
        return regiones;
        
    }
    
}
