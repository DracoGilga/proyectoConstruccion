
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemabibliotecario.POJO.Recurso;
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
    
    public static Recurso registrarRecursoDonado(Recurso recursoDonado) throws SQLException{
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
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
                 statement.setInt(7, recursoDonado.getNumDisponible());
                 
                 int resultSet = statement.executeUpdate();
                 
                 if (resultSet == 0){
                     recursoDonado.setIdRecurso(-1);
                     throw new SQLException("No se ha podido registrar " );
                 }             
                 else{
                     recursoDonado.setIdRecurso(buscarIdRecurso(recursoDonado.getISBN(), conexionBD));
                 }
                 
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }finally{
                 conexionBD.close();
             }
         }
         
        return recursoDonado;
    }
    
    public static int buscarIdRecurso(String isbn, Connection conexionBD) throws SQLException{
        int idRecurso = 0;
        
        String buscarRecurso = "SELECT idRecurso FROM recurso WHERE isbn = ? ";
        PreparedStatement statement = conexionBD.prepareCall(buscarRecurso);
        statement.setString(1, isbn);
        ResultSet resultadoConsulta = statement.executeQuery();
        
        if (resultadoConsulta.next())
            idRecurso = resultadoConsulta.getInt("idRecurso");
        
        return idRecurso;     
    }
}
