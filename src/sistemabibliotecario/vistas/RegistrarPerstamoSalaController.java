
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.PrestamoDAO;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.utills.Utilidades;


public class RegistrarPerstamoSalaController implements Initializable 
{

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

    Recurso recursoLibro;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }
    
    @FXML
    private void B_cancelar(ActionEvent event) 
    {
        cerrarVentana();
    }

    @FXML
    private void B_aceptar(ActionEvent event) 
    {
        LocalDate fechaPrestamo = D_fechaPrestamo.getValue();
                    
        try 
        {
            if(PrestamoDAO.registrarPrestamoSala(recursoLibro.getIdRecurso(), fechaPrestamo.toString()))
                Utilidades.mostrarAlerta("Exito", "Se registro el prestamo del libo", Alert.AlertType.CONFIRMATION);
            else 
                Utilidades.mostrarAlerta("Error", "no fue posible encontrar el recurso", Alert.AlertType.ERROR);
                       
        } 
        catch (SQLException ex) 
        {
            Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
            cerrarVentana();
        }
    }

    @FXML
    private void B_buscarRecurso(ActionEvent event) 
    {
        try 
        {
            String isbnRecurso = L_isbn.getText();
            recursoLibro = RecursoDAO.obtenerRecurso(isbnRecurso);
            
            if (recursoLibro.getIdRecurso()>0)
            {
                L_tituloRecurso.setText(recursoLibro.getTitulo());
                L_autorRecurso.setText(recursoLibro.getAutor());
                L_editorialRecurso.setText(recursoLibro.getAutor());
                L_anioRecurso.setText(recursoLibro.getAnio());
                L_edicionRecurso.setText(recursoLibro.getSerie());
                L_tomoRecurso.setText(Integer.toString(recursoLibro.getNumDisponible()));
            }
            else
                Utilidades.mostrarAlerta("Error", "no se encontro el Recurso Bibliotecario en el sistema de la biblioteca ", Alert.AlertType.ERROR);
        } 
        catch (SQLException ex) 
        {
            Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
        }
    }
    
    private void cerrarVentana()
    {
        Stage escenarioPrincipal = (Stage) L_isbn.getScene().getWindow();
        escenarioPrincipal.close();
    }
}
