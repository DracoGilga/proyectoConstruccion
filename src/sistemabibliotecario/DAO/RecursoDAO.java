
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
                 PreparedStatement consultaLogin = conexionBD.prepareCall(consulta);
                 consultaLogin.setString(1, isbn);
                 ResultSet resultadoConsulta = consultaLogin.executeQuery();
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
                {
                    recursoBibliotecario.setIdRecurso(-1);

                }
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
}
