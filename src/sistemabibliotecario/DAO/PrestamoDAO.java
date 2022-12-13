/*
 * DAO prestamo
 * Autor: Gonzalez Lopez Cesar
 * 10/12/2022
 * Modificación: 11/12/2022, Álvaro Barradas Fernández
 * Descripción: Dao de prestamo para el registro y solicitud de renovaciones de prestamos en el sistema
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemabibliotecario.POJO.Prestamo;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.conexionBD.ConexionBD;

public class PrestamoDAO 
{
    
    public static boolean registrarPrestamoSala(int idRecurso, String fechaPrestamoSala) throws SQLException
    {
        boolean bandera = false;
        Connection conexionBD = ConexionBD.abrirConexionBD();
         
        if (conexionBD != null) 
        {
            try {
                String guardarPrestamo = "INSERT INTO prestamosala ( idPrestamoSala , fechaPrestamo , idRecurso ) VALUES (NULL, ? , ? )";
                PreparedStatement statement = conexionBD.prepareCall(guardarPrestamo);
                 
                statement.setString(1, fechaPrestamoSala);
                statement.setInt(2, idRecurso);
                
                int resultSet = statement.executeUpdate();
                if (resultSet == 0)
                {
                   throw new SQLException("No se ha podido registrar " );
                } 
                else 
                {
                   bandera = true;
                }
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
    
    public static ArrayList<Prestamo> obtenerPrestamosActivos(String idUsuarioBibliotecario) throws SQLException
    {
        ArrayList<Prestamo> prestamos = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null)
        {
            
            try
            {
                
                String consulta = "SELECT * from prestamodomicilio WHERE idUsuarioBibliotecario = ?";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setString(1, idUsuarioBibliotecario);
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                prestamos = new ArrayList<>();
                while(resultadoConsulta.next())
                {
                    Prestamo prestamoObtenido = new Prestamo();
                    prestamoObtenido.setIdPrestamoDomicilio(resultadoConsulta.getInt("idPrestamoDomicilio"));
                    prestamoObtenido.setIdUsuarioBibliotecario(resultadoConsulta.getString("idUsuarioBibliotecario"));
                    prestamoObtenido.setIdRecurso(resultadoConsulta.getInt("idRecurso"));
                    prestamoObtenido.setFechaInicio(resultadoConsulta.getString("fechaInicio"));
                    prestamoObtenido.setFechaFin(resultadoConsulta.getString("fechaFin"));
                    prestamos.add(prestamoObtenido);
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        }
        return prestamos;
                
    }
    
    public static Prestamo obtenerPrestamoPorUsuario(String idUsuarioBibliotecario) throws SQLException
    {
        Connection conexionBD = ConexionBD.abrirConexionBD();
        Prestamo prestamoObtenido = new Prestamo();
        if(conexionBD != null)
        { 
            try
            {
                String sentencia = "SELECT * FROM prestamodomicilio WHERE idUsuarioBibliotecario = ?";
                PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
                preparedStatement.setString(1, idUsuarioBibliotecario);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) 
                {
                    prestamoObtenido.setIdPrestamoDomicilio(result.getInt("idPrestamoDomicilio"));
                    prestamoObtenido.setIdUsuarioBibliotecario(result.getString("idUsuarioBibliotecario"));
                    prestamoObtenido.setIdRecurso(result.getInt("idRecurso"));
                    prestamoObtenido.setFechaInicio(result.getString("fechaInicio"));
                    prestamoObtenido.setFechaFin(result.getString("fechaFin"));

                } else
                {
                    prestamoObtenido = null;
                    
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        
        }
        return prestamoObtenido;
        
    }
    
    public static ResultadoOperacion registrarRenovacion(Prestamo prestamoRenovacion) throws SQLException
    {
        
        ResultadoOperacion respuesta = new ResultadoOperacion();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        respuesta.setError(true);
        respuesta.setNumeroFilasAfectadas(-1);
        if(conexionBD != null)
        {
            
            try
            {
                Date dateFechaCierreNueva = Date.valueOf(prestamoRenovacion.getFechaFin());
                System.out.println(dateFechaCierreNueva);
                String consulta = "UPDATE prestamodomicilio SET fechaFin = ? "
                        + "WHERE idUsuarioBibliotecario = ?";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setDate(1, dateFechaCierreNueva);
                prepararConsulta.setString(2, prestamoRenovacion.getIdUsuarioBibliotecario());
                int numeroFilas = prepararConsulta.executeUpdate();
                    
                if(numeroFilas > 0)
                {
                    respuesta.setError(false);
                    respuesta.setMensaje("Renovacion exitosa.");
                    respuesta.setNumeroFilasAfectadas(numeroFilas);
                }else
                {
                    respuesta.setMensaje("No se pudo realizar la renovacion.");
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
