/*
 * 
 * 
 */
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;

public class RegistrarRecursoDonadoController implements Initializable 
{

 
    @FXML
    private TextField L_estadoDonacion;
    @FXML
    private TextField L_tituloDonacion;
    @FXML
    private TextField L_autorDonacion;
    @FXML
    private TextField L_editorialDonacion;
    @FXML
    private TextField L_edicionDonacion;
    @FXML
    private TextField L_anioRecursoDonacion;
    @FXML
    private TextField L_tomoDonacion;
    @FXML
    private TextField L_isbnRecurso;


 

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    }    
    @FXML
    private void B_cancelarDonacion(ActionEvent event) 
    {
        cerrarVentana();
    }

    @FXML
    private void B_registrarDonacion(ActionEvent event) 
    {
        try 
        {           
            Recurso donacion = new Recurso(L_tituloDonacion.getText(),L_editorialDonacion.getText(), L_autorDonacion.getText(), L_isbnRecurso.getText(), 
                    L_edicionDonacion.getText(), L_estadoDonacion.getText(), Integer.parseInt(L_tomoDonacion.getText()), L_anioRecursoDonacion.getText());
            
            ResultadoOperacion resultadoGuardar = RecursoDAO.registrarRecursoDonado(donacion);
               
            if(!resultadoGuardar.isError())
               {
                   Utilidades.mostrarAlerta("recurso donado registrado", resultadoGuardar.getMensaje(), Alert.AlertType.INFORMATION);
                   cerrarVentana();
               } else 
                   Utilidades.mostrarAlerta("Error al registrar recurso donado", resultadoGuardar.getMensaje(), Alert.AlertType.ERROR);   
        } 
        catch(SQLException ex)
        {
            Utilidades.mostrarAlerta("Error de conexión", ex.getMessage(), Alert.AlertType.ERROR);            
        }
    }
    
    private void cerrarVentana()
    {
        Stage escenarioPrincipal = (Stage) L_estadoDonacion.getScene().getWindow();
        escenarioPrincipal.close();
    }
}
