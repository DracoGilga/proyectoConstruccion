/*
 * DAO UsuarioBibliotecario
 * Autor: Álvaro Barradas Fernández
 * 10/12/2022
 * Descripción: Dao de usuario bibliotecario para el registro de este al sistema
 */
package sistemabibliotecario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.POJO.UsuarioBibliotecario;
import sistemabibliotecario.conexionBD.ConexionBD;

public class UsuarioBibliotecarioDAO 
{
    
    public static ResultadoOperacion registrarUsuarioBibliotecario(UsuarioBibliotecario usuarioNuevo) throws SQLException
    {
        
       ResultadoOperacion respuesta = new ResultadoOperacion();
       Connection conexionBD = ConexionBD.abrirConexionBD();
       respuesta.setError(true);
       respuesta.setNumeroFilasAfectadas(-1);
       if(conexionBD != null)
       {
           
           try
           {
               
               String sentencia = "INSERT INTO usuariobibliotecario (idUsuariobibliotecario, nombre, apellidoPaterno, apellidoMaterno, "
                       + "direccion, idRegion, idCarrera) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
               PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
               preparedStatement.setString(1, usuarioNuevo.getIdUsuarioBibliotecario());
               preparedStatement.setString(2, usuarioNuevo.getNombre());
               preparedStatement.setString(3, usuarioNuevo.getApellidoPaterno());
               preparedStatement.setString(4, usuarioNuevo.getApellidoMaterno());
               preparedStatement.setString(5, usuarioNuevo.getDireccion());
               preparedStatement.setInt(6, usuarioNuevo.getIdRegion());
               preparedStatement.setInt(7, usuarioNuevo.getIdCarrera());
               
               int numeroFilas = preparedStatement.executeUpdate();
               if(numeroFilas>0)
                {
                    
                    respuesta.setError(false);
                    respuesta.setMensaje("Usuario registrado correctamente");
                    respuesta.setNumeroFilasAfectadas(numeroFilas);
                    
                } else
                {
                    
                    respuesta.setMensaje("No se pudo registrar la informacion del usuario");
                    
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
     public static ArrayList<UsuarioBibliotecario> obtenerUsuariosBibliotecarios() throws SQLException
    {
        Connection conexionBD = ConexionBD.abrirConexionBD();
        ArrayList<UsuarioBibliotecario> usuarios = new ArrayList<>();
        if(conexionBD != null)
        {
            
            try
            {
                
                String consulta = "SELECT * from usuariobibliotecario";
                PreparedStatement consultaObtenerTodos = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = consultaObtenerTodos.executeQuery();
                while(resultadoConsulta.next())
                {
                    sistemabibliotecario.POJO.UsuarioBibliotecario usuarioObtenido = new UsuarioBibliotecario();
                    usuarioObtenido.setIdUsuarioBibliotecario(resultadoConsulta.getString("idUsuarioBibliotecario"));
                    usuarioObtenido.setNombre(resultadoConsulta.getString("nombre"));
                    usuarioObtenido.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                    usuarioObtenido.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                    usuarioObtenido.setDireccion(resultadoConsulta.getString("direccion"));
                    usuarioObtenido.setIdRegion(resultadoConsulta.getInt("idRegion"));
                    usuarioObtenido.setIdCarrera(resultadoConsulta.getInt("idCarrera"));
                    usuarios.add(usuarioObtenido);
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        }
        return usuarios;
                
    }
     
    public static UsuarioBibliotecario obtenerUsuarioPorId(String idUsuarioBibliotecario) throws SQLException
    {
        Connection conexionBD = ConexionBD.abrirConexionBD();
        UsuarioBibliotecario usuarioObtenido = new UsuarioBibliotecario();
        if(conexionBD != null)
        { 
            try
            {
                String sentencia = "SELECT * FROM usuariobibliotecario WHERE idUsuarioBibliotecario = ?";
                PreparedStatement preparedStatement = conexionBD.prepareStatement(sentencia);
                preparedStatement.setString(1, idUsuarioBibliotecario);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) 
                {
                    usuarioObtenido.setIdUsuarioBibliotecario(result.getString("idUsuarioBibliotecario"));
                    usuarioObtenido.setNombre(result.getString("nombre"));
                    usuarioObtenido.setApellidoPaterno(result.getString("apellidoPaterno"));
                    usuarioObtenido.setApellidoMaterno(result.getString("apellidoMaterno"));
                    usuarioObtenido.setDireccion(result.getString("direccion"));
                    usuarioObtenido.setIdRegion(result.getInt("idRegion"));
                    usuarioObtenido.setIdCarrera(result.getInt("idCarrera"));
                } else
                {
                    usuarioObtenido = null;
                    
                }
            } catch(SQLException ex)
            {
                
                ex.printStackTrace();
                
            } finally
            {
                
                conexionBD.close();
                
            }
            
        
        }
        return usuarioObtenido;
        
    }
}
