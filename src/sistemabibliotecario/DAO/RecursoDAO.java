/*
 * DAO Recurso
 * Autor: Gonzalez Lopez Cesar
 * 11/12/2022
 * Descripción: Dao de recurso para el registro de estos al sistema
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.conexionBD.ConexionBD;

public class RecursoDAO 
{
    
    public static Recurso obtenerRecurso (String isbnRecurso) throws SQLException
    {
        Recurso recursoBibliotecario = null;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
        if(conexionBD != null)
        {
            try 
            {
                String consulta = "SELECT idRecurso, titulo, editorial, autor, edicion, isbn, tomo, anio, estado  FROM  recurso  WHERE isbn = ? ";
                 PreparedStatement consultaLogin = conexionBD.prepareCall(consulta);
                 consultaLogin.setString(1, isbnRecurso);
                 ResultSet resultadoConsulta = consultaLogin.executeQuery();
                 recursoBibliotecario = new Recurso();
                 if(resultadoConsulta.next())
                {
                    recursoBibliotecario.setIdRecurso(resultadoConsulta.getInt("idRecurso"));
                    recursoBibliotecario.setTitulo(resultadoConsulta.getString("titulo"));
                    recursoBibliotecario.setEditorial(resultadoConsulta.getString("editorial"));
                    recursoBibliotecario.setAutor(resultadoConsulta.getString("autor"));
                    recursoBibliotecario.setEdicion(resultadoConsulta.getString("edicion"));
                    recursoBibliotecario.setIsbn(resultadoConsulta.getString("isbn"));
                    recursoBibliotecario.setTomo(resultadoConsulta.getInt("tomo"));
                    recursoBibliotecario.setAnio(resultadoConsulta.getString("anio"));
                    recursoBibliotecario.setEstado(resultadoConsulta.getString("estado"));
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
    
    public static ResultadoOperacion registrarRecursoDonado(Recurso recursoDonado) throws SQLException
    {
        
        ResultadoOperacion respuesta = new ResultadoOperacion();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        respuesta.setError(true);
        respuesta.setNumeroFilasAfectadas(-1);
        
         if(conexionBD != null)
         {
             try {
                 String guardarRecurso = "INSERT INTO recurso "
                         + "(titulo, editorial, autor, edicion, isbn, tomo, anio, estado) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conexionBD.prepareCall(guardarRecurso);
                 
                statement.setString(1, recursoDonado.getTitulo());
                statement.setString(2, recursoDonado.getEditorial());
                statement.setString(3, recursoDonado.getAutor());
                statement.setString(4, recursoDonado.getEdicion());
                statement.setString(5, recursoDonado.getIsbn());
                statement.setInt(6, recursoDonado.getTomo());
                statement.setString(7, recursoDonado.getAnio());
                statement.setString(8, recursoDonado.getEstado());
                 
                int numeroFilas = statement.executeUpdate();
                 
                if(numeroFilas>0)
                {
                    respuesta.setError(false);
                    respuesta.setMensaje("Recurso donado registrado correctamente");
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
    
    public static ArrayList<Recurso> obtenerRecursos() throws SQLException
    {
        Connection conexionBD = ConexionBD.abrirConexionBD();
        ArrayList<Recurso> recursos = new ArrayList<>();
        if(conexionBD != null)
        {
            
            try
            {
                
                String consulta = "SELECT * from recurso";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
                while(resultadoConsulta.next())
                {
                    Recurso recursoObtenido = new Recurso();
                    recursoObtenido.setIdRecurso(resultadoConsulta.getInt("idRecurso"));
                    recursoObtenido.setTitulo(resultadoConsulta.getString("titulo"));
                    recursoObtenido.setEditorial(resultadoConsulta.getString("editorial"));
                    recursoObtenido.setAutor(resultadoConsulta.getString("autor"));
                    recursoObtenido.setEdicion(resultadoConsulta.getString("edicion"));
                    recursoObtenido.setIsbn(resultadoConsulta.getString("isbn"));
                    recursoObtenido.setTomo(resultadoConsulta.getInt("tomo"));
                    recursoObtenido.setAnio(resultadoConsulta.getString("anio"));
                    recursoObtenido.setEstado(resultadoConsulta.getString("estado"));
                    recursos.add(recursoObtenido);
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        }
        return recursos;
                
    }
    
    public static Recurso obtenerRecursoPorId(int idRecurso) throws SQLException
    {
        Connection conexionBD = ConexionBD.abrirConexionBD();
        Recurso recursoObtenido = new Recurso();
        if(conexionBD != null)
        { 
            try
            {
                String sentencia = "SELECT * FROM recurso WHERE idRecurso = ?";
                PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
                preparedStatement.setInt(1, idRecurso);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) 
                {
                    recursoObtenido.setIdRecurso(result.getInt("idRecurso"));
                    recursoObtenido.setTitulo(result.getString("titulo"));
                    recursoObtenido.setEditorial(result.getString("editorial"));
                    recursoObtenido.setAutor(result.getString("autor"));
                    recursoObtenido.setEdicion(result.getString("edicion"));
                    recursoObtenido.setIsbn(result.getString("isbn"));
                    recursoObtenido.setTomo(result.getInt("tomo"));
                    recursoObtenido.setAnio(result.getString("anio"));
                    recursoObtenido.setEstado(result.getString("estado"));
                } else
                {
                    recursoObtenido = null;
                    
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        
        }
        return recursoObtenido;
        
    }
    
}
