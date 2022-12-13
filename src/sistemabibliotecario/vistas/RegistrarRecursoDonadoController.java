/*
 * CU02 Registrar recurso donado
 * Autor: Gonzalez Lopez Cesar
 * Fecha de creación: 11/12/2022
 * Descripción: Ventana para el registro de recursos donados
 */
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;

public class RegistrarRecursoDonadoController implements Initializable {

    @FXML
    private TextField TF_titulo;
    @FXML
    private TextField TF_isbn;
    @FXML
    private TextField TF_estado;
    @FXML
    private TextField TF_editorial;
    @FXML
    private TextField TF_autor;
    @FXML
    private TextField TF_anio;
    @FXML
    private TextField TF_edicion;
    @FXML
    private TextField TF_tomo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicCancelar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }

    @FXML
    private void clicRegistrar(ActionEvent event) 
    {
        String titulo = TF_titulo.getText();
        String editorial = TF_editorial.getText();
        String autor = TF_autor.getText();
        String edicion = TF_edicion.getText();
        String isbn = TF_isbn.getText();
        String anio = TF_anio.getText();
        String estado = TF_estado.getText();
        boolean valido = true;
        if(titulo.isEmpty() || editorial.isEmpty() || autor.isEmpty() || edicion.isEmpty() || isbn.isEmpty() || anio.isEmpty() || estado.isEmpty())
        {
            valido = false;
            Utilidades.mostrarAlerta("Faltan datos", "Es necesario que llene todos los campos solicitados", Alert.AlertType.INFORMATION);
            TF_titulo.setText("");
            TF_editorial.setText("");
            TF_autor.setText("");
            TF_edicion.setText("");
            TF_isbn.setText("");
            TF_tomo.setText("");
            TF_anio.setText("");
            TF_estado.setText("");
        }
        if(valido)
            try 
            {           
                Recurso donacion = new Recurso(-1, TF_titulo.getText(), TF_editorial.getText(), 
                    TF_autor.getText(), TF_edicion.getText(), TF_isbn.getText(), 
                    Integer.parseInt(TF_tomo.getText()), TF_anio.getText(), TF_estado.getText());
                ResultadoOperacion resultadoGuardar = RecursoDAO.registrarRecursoDonado(donacion);
               
                if(!resultadoGuardar.isError())
                {
                   Utilidades.mostrarAlerta("Recurso donado registrado", resultadoGuardar.getMensaje(), Alert.AlertType.INFORMATION);
                   TF_titulo.setText("");
                   TF_editorial.setText("");
                   TF_autor.setText("");
                   TF_edicion.setText("");
                   TF_isbn.setText("");
                   TF_tomo.setText("");
                   TF_anio.setText("");
                   TF_estado.setText("");
                } else 
                {
                    Utilidades.mostrarAlerta("Error al registrar recurso donado", resultadoGuardar.getMensaje(), Alert.AlertType.ERROR);
                    TF_titulo.setText("");
                    TF_editorial.setText("");
                    TF_autor.setText("");
                    TF_edicion.setText("");
                    TF_isbn.setText("");
                    TF_tomo.setText("");
                    TF_anio.setText("");
                    TF_estado.setText("");
                }
                   
            
            } 
            catch(SQLException ex)
            {
                Utilidades.mostrarAlerta("Error de conexión", ex.getMessage(), Alert.AlertType.ERROR);            
            }
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) TF_titulo.getScene().getWindow();
        escenarioPrincipal.close();
        
    }
    
}
