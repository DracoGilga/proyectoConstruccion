package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistemabibliotecario.conexionBD.ConexionBD;


public class PrestamoDAO 
{
    public static boolean registrarPrestamoSala(int idRecurso, String fechaPrestamoSala) throws SQLException
    {
        boolean bandera = false;
         Connection conexionBD = ConexionBD.abrirConexionBD();
         
         if (conexionBD != null) 
         {
             try 
             {
                 String guardarPrestamo = "INSERT INTO prestamo ( idPrestamo , fechaPrestamo , idRecurso ) VALUES (NULL, ? , ? )";
                 PreparedStatement statement = conexionBD.prepareCall(guardarPrestamo);
                 
                 statement.setString(1, fechaPrestamoSala);
                 statement.setInt(2, idRecurso);
                
                 int resultSet = statement.executeUpdate();
                 
                 if (resultSet == 0)
                    throw new SQLException("No se ha podido registrar " );
                 else 
                    bandera = true;
                 
             } 
             catch (SQLException ex) 
             {
                 ex.printStackTrace();
             }
             finally
             {
                 conexionBD.close();
             }
        }

        return bandera;
    }
}
