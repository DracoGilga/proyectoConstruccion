
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.conexionBD.ConexionBD;


public class RecursoDAO 
{
    public static Recurso obtenerRecurso (String isbn) throws SQLException 
    {
        Recurso recursoBibliotecario = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
        if(conexionBD != null)
        {
            try 
            {
                String consulta = "SELECT titulo , autor , editor , danio , serie , numDisponible  FROM  recurso  WHERE ISBN = ? ";
                 PreparedStatement busquedaRecurso = conexionBD.prepareCall(consulta);
                 busquedaRecurso.setString(1, isbn);
                 ResultSet resultadoConsulta = busquedaRecurso.executeQuery();
                 recursoBibliotecario = new Recurso();
                
                 if(resultadoConsulta.next())
                {
                    recursoBibliotecario.setTitulo(resultadoConsulta.getString("titulo"));
                    recursoBibliotecario.setAutor(resultadoConsulta.getString("autor"));
                    recursoBibliotecario.setEditor(resultadoConsulta.getString("editor"));
                    recursoBibliotecario.setAnio(resultadoConsulta.getString("anio"));
                    recursoBibliotecario.setSerie(resultadoConsulta.getString("serie"));
                    recursoBibliotecario.setNumDisponible(resultadoConsulta.getInt("numDisponible"));
                    recursoBibliotecario.setIdRecurso(resultadoConsulta.getInt("idRecurso"));
                }
                 else
                    recursoBibliotecario.setIdRecurso(-1);
                
            }
            catch (SQLException ex ) 
            {
                ex.printStackTrace();
            }
            finally
            {
                conexionBD.close();
            }
            
        }
        
        return recursoBibliotecario;
    }
    
    public static ResultadoOperacion registrarRecursoDonado(Recurso recursoDonado) throws SQLException{
        ResultadoOperacion respuesta = new ResultadoOperacion();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        respuesta.setError(true);
        respuesta.setNumeroFilasAfectadas(-1);
        
         if(conexionBD != null)
         {
             try {
                 String guardarRecurso = "INSERT INTO recurso "
                         + "( idRecurso , titulo , editor , autor , tema , isbn , serie , anio , estado , numDisponible) "
                         + "VALUES (NULL, ? , ? , ? , NULL , ? , ? , ? , ? , ? )";
                PreparedStatement statement = conexionBD.prepareCall(guardarRecurso);
                 
                statement.setString(1, recursoDonado.getTitulo());
                statement.setString(2, recursoDonado.getEditor());
                statement.setString(3, recursoDonado.getAutor());
                statement.setString(4, recursoDonado.getISBN());
                statement.setString(5, recursoDonado.getSerie());
                statement.setString(6, recursoDonado.getAnio());
                statement.setString(7, recursoDonado.getEstado());
                statement.setInt(8, recursoDonado.getNumDisponible());
                 
                int numeroFilas = statement.executeUpdate();
                 
                if(numeroFilas>0)
                {
                    respuesta.setError(false);
                    respuesta.setMensaje("recurso donado registrado correctamente");
                    respuesta.setNumeroFilasAfectadas(numeroFilas);                    
                } 
                else
                    respuesta.setMensaje("No se pudo registrar la informacion del recurso");
                 
             } catch (SQLException ex) {
                 respuesta.setMensaje(ex.getMessage());   
             }finally{
                 conexionBD.close();
             }
         }
         else
             respuesta.setMensaje("Por el momento no hay conexión con la base de datos");
         
        return respuesta;
    }
    
}
