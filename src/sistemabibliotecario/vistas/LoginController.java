/*
 * 
 * 
 */
package sistemabibliotecario.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.UsuarioDAO;
import sistemabibliotecario.POJO.Usuario;
import sistemabibliotecario.utills.Constantes;
import sistemabibliotecario.utills.Utilidades;

public class LoginController implements Initializable {

    @FXML
    private TextField tf_NombreUsuario;
    @FXML
    private PasswordField pf_Password;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void clicIniciarSesion(ActionEvent event) throws IOException
    {
        
        String nombreUsuario = tf_NombreUsuario.getText();
        String password = pf_Password.getText();
        boolean valido = true;
        
        if(nombreUsuario.isEmpty() || password.isEmpty())
        {
            
            valido = false;
            Utilidades.mostrarAlerta("Faltan datos", "No se puede dejar ningún campo vacío.\n\n"
                    + "Por favor, compruebe la información ingresada e inténtelo nuevamente.\n",
                    Alert.AlertType.WARNING);
            tf_NombreUsuario.setText("");
            pf_Password.setText("");
            
        }
        if(valido)
            iniciarSesion(nombreUsuario, password);
        
        
    }

    private void iniciarSesion(String nombreUsuario, String password)
    {
        
        try
       {
           
           Usuario usuarioSesion = UsuarioDAO.iniciarSesion(nombreUsuario, password);
           if(usuarioSesion.getIdUsuario() > 0)
           {
               
               irMenuPrincipal(usuarioSesion);
               
           }else
           {
               
               Utilidades.mostrarAlerta("Credenciales incorrectas", "Compruebe los datos ingresados e intentelo de nuevo ", Alert.AlertType.ERROR);
               
           }
           
       } catch(SQLException ex)
       {
           
           Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
           
       } catch(NullPointerException n)
       {
           
           Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
           
       }
        
    }

    private void irMenuPrincipal(Usuario usuarioSesion) 
    {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
        try
        {
            
            Utilidades.mostrarAlerta("Bienvenid@", "Credenciales correctas, bienvenid@ al sistema", Alert.AlertType.INFORMATION);
            Parent vista = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
            Scene escenaPrincipal = new Scene(vista);
            Stage escenarioBase = (Stage) tf_NombreUsuario.getScene().getWindow();
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Menu principal");
            escenarioBase.show();
            
        } catch(IOException ex) 
        {
            
            ex.printStackTrace();
            Utilidades.mostrarAlerta("Error", "No se puede mostrar la pantalla principal", Alert.AlertType.ERROR);
            
        }
        
    }
    
}
