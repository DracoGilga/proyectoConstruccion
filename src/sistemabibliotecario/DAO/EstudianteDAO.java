/*
 * 
 * 
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.POJO.Estudiante;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.conexionBD.ConexionBD;

public class EstudianteDAO 
{
    
    public static ResultadoOperacion registrarEstudiante(Estudiante estudianteNuevo) throws SQLException
    {
        
       ResultadoOperacion respuesta = new ResultadoOperacion();
       Connection conexionBD = ConexionBD.abrirConexionBD();
       respuesta.setError(true);
       respuesta.setNumeroFilasAfectadas(-1);
       if(conexionBD != null)
       {
           
           try
           {
               
               String sentencia = "INSERT INTO estudiante (matricula, nombre, apellidoPaterno, apellidoMaterno, "
                       + "direccion, idCarrera, idRegion) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
               PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
               preparedStatement.setString(1, estudianteNuevo.getMatricula());
               preparedStatement.setString(2, estudianteNuevo.getNombre());
               preparedStatement.setString(3, estudianteNuevo.getApellidoPaterno());
               preparedStatement.setString(4, estudianteNuevo.getApellidoMaterno());
               preparedStatement.setString(5, estudianteNuevo.getDireccion());
               preparedStatement.setInt(6, estudianteNuevo.getIdCarrera());
               preparedStatement.setInt(7, estudianteNuevo.getIdRegion());
               
               int numeroFilas = preparedStatement.executeUpdate();
               if(numeroFilas>0)
                {
                    
                    respuesta.setError(false);
                    respuesta.setMensaje("Alumno registrado correctamente");
                    respuesta.setNumeroFilasAfectadas(numeroFilas);
                    
                } 
               else
                    respuesta.setMensaje("No se pudo registrar la informacion del almno");
    
           } catch(SQLException ex)
           {
               respuesta.setMensaje(ex.getMessage());   
           } finally
           {
               conexionBD.close();   
           }
        } 
       else            
            respuesta.setMensaje("Por el momento no hay conexión con la base de datos");
       
        return respuesta;
    }
    
    public static Estudiante buscarIdEstudiante(String matriculaEstudiante) throws SQLException{
        Estudiante estudiante = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
        if(conexionBD != null){
            try {
                String consulta = "SELECT idEstudiante FROM estudiante WHERE matricula = ? ";
                PreparedStatement busquedaAlumno = conexionBD.prepareCall(consulta);
                busquedaAlumno.setString(1, matriculaEstudiante);
                ResultSet resultadoConsulta = busquedaAlumno.executeQuery();
                estudiante = new Estudiante();

                if(resultadoConsulta.next())
                    estudiante.setIdEstudiante(resultadoConsulta.getInt("idEstudiante"));
                else
                    estudiante.setIdEstudiante(-1);
            } catch (SQLException ex ) {
                ex.printStackTrace();
            }finally{
                conexionBD.close();
            }
           
            
        }
        
        return estudiante;
        
    }
}
