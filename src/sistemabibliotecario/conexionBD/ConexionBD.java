/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabibliotecario.conexionBD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class ConexionBD 
{
    private static String driver = "com.mysql.jdbc.Driver";
    private static String baseDatos = "jdbc:mysql://localhost:3306/sistemabibliotecario";
    private static String usuario = "Administrador";
    private static String contrasena = "123456";
    
    public static Connection abrirConeccionBD() 
    {
        Connection conexionBD = null;   
        try 
        {
            Class.forName(driver);
            conexionBD = (Connection) DriverManager.getConnection(baseDatos, usuario, contrasena);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conexionBD;
    }
}
