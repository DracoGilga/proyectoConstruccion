/*
 * CU08 Registrar prestamo en sala
 * Autor: Gonzalez Lopez Cesar
 * Fecha de creación: 10/12/2022
 * Descripción: Ventana para el registro de prestamos de recursos en sala
 */
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.PrestamoDAO;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.utills.Utilidades;


public class RegistrarPrestamoSalaController implements Initializable 
{
    
    @FXML
    private TextField TF_isbn;
    @FXML
    private TextField TF_autor;
    @FXML
    private TextField TF_anio;
    @FXML
    private TextField TF_titulo;
    @FXML
    private TextField TF_editorial;
    @FXML
    private TextField TF_edicion;
    @FXML
    private TextField TF_tomo;
    @FXML
    private DatePicker DP_fechaPrestamo;
    @FXML
    private Button BTN_aceptar;
    
    Recurso recursoLibro;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BTN_aceptar.setDisable(true);
    }    

    @FXML
    private void clicCancelar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }

    @FXML
    private void clicAceptar(ActionEvent event) 
    {
        
        LocalDate fechaPrestamo = DP_fechaPrestamo.getValue();
        if(!fechaPrestamo.equals(""))
        {
           try 
           {
                if(PrestamoDAO.registrarPrestamoSala(recursoLibro.getIdRecurso(), fechaPrestamo.toString()))
                {
                    Utilidades.mostrarAlerta("Exito", "Se registro el prestamo del recurso", Alert.AlertType.INFORMATION);
                    TF_isbn.setText("");
                    TF_autor.setText("");
                    TF_anio.setText("");
                    TF_titulo.setText("");
                    TF_editorial.setText("");
                    TF_edicion.setText("");
                    TF_tomo.setText("");
                    DP_fechaPrestamo.setValue(null);
                    BTN_aceptar.setDisable(true);
                }
                else
                {
                    Utilidades.mostrarAlerta("Error", "No fue posible registrar el restamo", Alert.AlertType.ERROR);
                }
            
            } catch (SQLException ex)
            {
                Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
            } 
        } else
        {
            Utilidades.mostrarAlerta("Falta fecha", "Es necesario seleccionar una fecha del prestamo", Alert.AlertType.INFORMATION);
        }
        
        
    }

    @FXML
    private void clicBuscar(ActionEvent event) 
    {
        
        try 
        {
            String isbnRecurso = TF_isbn.getText();
            recursoLibro = RecursoDAO.obtenerRecurso(isbnRecurso);
            if(!isbnRecurso.isEmpty())
            {
                if (recursoLibro.getIdRecurso()>0)
                {
                    TF_titulo.setText(recursoLibro.getTitulo());
                    TF_autor.setText(recursoLibro.getAutor());
                    TF_editorial.setText(recursoLibro.getEditorial());
                    TF_anio.setText(recursoLibro.getAnio());
                    TF_edicion.setText(recursoLibro.getEdicion());
                    TF_tomo.setText(Integer.toString(recursoLibro.getTomo()));
                    BTN_aceptar.setDisable(false);
                }
                else
                    Utilidades.mostrarAlerta("Error", "No se encontro el Recurso Bibliotecario en el sistema de la biblioteca ", Alert.AlertType.ERROR);
            } else
            {
                Utilidades.mostrarAlerta("Alerta", "El campo de ISBN es necesario", Alert.AlertType.INFORMATION);
                TF_isbn.setText("");
                TF_autor.setText("");
                TF_anio.setText("");
                TF_titulo.setText("");
                TF_editorial.setText("");
                TF_edicion.setText("");
                TF_tomo.setText("");
                DP_fechaPrestamo.setValue(null);
                BTN_aceptar.setDisable(true);
            }
                
        } 
        catch (SQLException ex) 
        {
            Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
        }
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) TF_isbn.getScene().getWindow();
        escenarioPrincipal.close();
        
    }
    
}
