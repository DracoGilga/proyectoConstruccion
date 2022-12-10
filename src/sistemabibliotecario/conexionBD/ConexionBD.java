package sistemabibliotecario.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD 
{
    private static String driver = "com.mysql.jdbc.Driver";
    private static String bd = "sistemabibliotecario";
    private static String ip = "localhost";
    private static String puerto = "3306";
    private static String urlConexion = "jdbc:mysql://"+ip+":"+puerto+"/"+bd+"?allowPublicKeyRetrieval=true&useSSL=false";
    private static String usuario = "root";
    private static String password = "teamosam";
    
    public static java.sql.Connection abrirConexionBD(){
        Connection conexionBD = null;
        try
        {
            
            Class.forName(driver);
            conexionBD = DriverManager.getConnection(urlConexion, usuario, password);
            
        } catch(ClassNotFoundException ex)
        {
            
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
        }
        
        return conexionBD;
    }
    
}
