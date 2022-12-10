/*
 * 
 * 
 */
package sistemabibliotecario.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistemabibliotecario.POJO.Usuario;
import sistemabibliotecario.utills.Utilidades;

public class MenuPrincipalController implements Initializable 
{

    @FXML
    private Button btn_CerrarSesion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        
    }

    @FXML
    private void clicCerrarSesion(ActionEvent event) 
    {
        
        FXMLLoader vista = new FXMLLoader(getClass().getResource("Login.fxml"));
        try {
            Parent root = vista.load();
            LoginController loginController = vista.getController();
            Stage stage = (Stage) btn_CerrarSesion.getScene().getWindow();
            Scene loginView = new Scene(root);
            stage.setScene(loginView);
            stage.setTitle("Iniciar sesión.");
            stage.show();
        } catch (IOException exception) {
            System.err.println("Error al cargar \"Login\" ventana...");
        }
        
    }

    @FXML
    private void clicRegistrarRecurso(ActionEvent event) 
    {
        
        try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("RegistrarRecursoDonado.fxml"));
            Scene escenaRecurso = new Scene(vista);
             Stage escenarioNuevo = new Stage();
            escenarioNuevo.setScene(escenaRecurso);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Registrar recurso donado");
            escenarioNuevo.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar registrar recurso donado", Alert.AlertType.ERROR);
            
        }
        
        
        
    }

    @FXML
    private void clicRegistrarUsuario(ActionEvent event) 
    {
        
        try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("RegistrarUsuario.fxml"));
            Scene escenaUsuario = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setScene(escenaUsuario);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Registrar usuario");
            escenarioNuevo.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar registrar usuario", Alert.AlertType.ERROR);
            
        }
        
    }

    @FXML
    private void clicRegistrarPrestamo(ActionEvent event) 
    {
        
        try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("RegistrarPrestamoSala.fxml"));
            Scene escenaPrestamo = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setScene(escenaPrestamo);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Registrar prestamo en sala");
            escenarioNuevo.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar registrar prestamo en sala", Alert.AlertType.ERROR);
            
        }
        
    }

    @FXML
    private void clicSolicitarRenovacion(ActionEvent event) 
    {
        
        try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("SolicitarRenovacion.fxml"));
            Scene escenaRenovacion = new Scene(vista);
            Stage escenarioNuevo = new Stage();
            escenarioNuevo.setScene(escenaRenovacion);
            escenarioNuevo.initModality(Modality.APPLICATION_MODAL);
            escenarioNuevo.setTitle("Solicitar renovacion");
            escenarioNuevo.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar solicitar renovacion", Alert.AlertType.ERROR);
            
        }
        
    }
    
    
}
