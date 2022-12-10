
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.utills.Utilidades;


public class RegistrarPerstamoSalaController implements Initializable 
{

    @FXML
    private ComboBox<?> CB_tipoPrestamo;
    @FXML
    private TextField L_isbn;
    @FXML
    private TextField L_autorRecurso;
    @FXML
    private TextField L_anioRecurso;
    @FXML
    private TextField L_tituloRecurso;
    @FXML
    private TextField L_editorialRecurso;
    @FXML
    private TextField L_edicionRecurso;
    @FXML
    private TextField L_tomoRecurso;
    @FXML
    private DatePicker D_fechaPrestamo;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }
    
    @FXML
    private void B_cancelar(ActionEvent event) 
    {
    }

    @FXML
    private void B_aceptar(ActionEvent event) 
    {
    }

    @FXML
    private void B_buscarRecurso(ActionEvent event) 
    {
        try {
            String isbnRecurso = L_isbn.getText();
            Recurso recursoLibro = RecursoDAO.obtenerRecurso(isbnRecurso);
            
            if (recursoLibro.getIdRecurso()>0)
            {
                
            }
            else
                Utilidades.mostrarAlerta("Error", "no se encontro el Recurso Bibliotecario en el sistema de la biblioteca ", Alert.AlertType.ERROR);
        
        } catch (SQLException ex) {
            Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
        }
        
    }
    
}
