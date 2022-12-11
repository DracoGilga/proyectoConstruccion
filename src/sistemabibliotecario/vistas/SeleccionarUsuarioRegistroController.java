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
import sistemabibliotecario.utills.Utilidades;

public class SeleccionarUsuarioRegistroController implements Initializable {

    @FXML
    private Button btn_Cancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
        
        
        
    }    

    @FXML
    private void clicEstudiante(ActionEvent event) 
    {
        
      try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("RegistrarAlumno.fxml"));
            Scene escenaAlumno = new Scene(vista);
            Stage escenarioAlumno = new Stage();
            escenarioAlumno.setScene(escenaAlumno);
            escenarioAlumno.initModality(Modality.APPLICATION_MODAL);
            escenarioAlumno.setTitle("Registrar alumno");
            escenarioAlumno.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar registrar alumno", Alert.AlertType.ERROR);
            
        }  
        
    }

    @FXML
    private void clicDocente(ActionEvent event) 
    {
        
        try
        {
            
            Parent vista = FXMLLoader.load(getClass().getResource("RegistrarDocente.fxml"));
            Scene escenaDocente = new Scene(vista);
            Stage escenarioDocente = new Stage();
            escenarioDocente.setScene(escenaDocente);
            escenarioDocente.initModality(Modality.APPLICATION_MODAL);
            escenarioDocente.setTitle("Registrar docente");
            escenarioDocente.showAndWait();
            
        } catch(IOException ie)
        {
            
            Utilidades.mostrarAlerta("Error", "Error al cargar registrar docente", Alert.AlertType.ERROR);
            
        }
        
    }

    @FXML
    private void clicCancelar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) btn_Cancelar.getScene().getWindow();
        escenarioPrincipal.close();
        
    }
    
}
