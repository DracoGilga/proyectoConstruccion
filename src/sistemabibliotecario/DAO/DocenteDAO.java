/*
 *
 * 
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistemabibliotecario.POJO.Docente;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.conexionBD.ConexionBD;

public class DocenteDAO 
{
    
    public static ResultadoOperacion registrarDocente(Docente docenteNuevo) throws SQLException
    {
        
       ResultadoOperacion respuesta = new ResultadoOperacion();
       Connection conexionBD = ConexionBD.abrirConexionBD();
       respuesta.setError(true);
       respuesta.setNumeroFilasAfectadas(-1);
       if(conexionBD != null)
       {
           
           try
           {
               
               String sentencia = "INSERT INTO docente (numeroPersonal, nombre, apellidoPaterno, apellidoMaterno, "
                       + "direccion, idRegion) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
               PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
               preparedStatement.setString(1, docenteNuevo.getNumeroPersonal());
               preparedStatement.setString(2, docenteNuevo.getNombre());
               preparedStatement.setString(3, docenteNuevo.getApellidoPaterno());
               preparedStatement.setString(4, docenteNuevo.getApellidoMaterno());
               preparedStatement.setString(5, docenteNuevo.getDireccion());
               preparedStatement.setInt(6, docenteNuevo.getIdRegion());
               
               int numeroFilas = preparedStatement.executeUpdate();
               if(numeroFilas>0)
                {
                    
                    respuesta.setError(false);
                    respuesta.setMensaje("Docente registrado correctamente");
                    respuesta.setNumeroFilasAfectadas(numeroFilas);
                    
                } else
                {
                    
                    respuesta.setMensaje("No se pudo registrar la informacion del docente");
                    
                }
               
           } catch(SQLException ex)
           {
               
               respuesta.setMensaje(ex.getMessage());
               
           } finally
           {
               
               conexionBD.close();
               
           }
           
       } else
        {
            
            respuesta.setMensaje("Por el momento no hay conexión con la base de datos");
            
        }
       
        return respuesta;
        
    }
    
}
