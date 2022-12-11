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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.EstudianteDAO;
import sistemabibliotecario.POJO.Estudiante;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.utills.Utilidades;

public class RegistrarRecursoDonadoController implements Initializable {

    @FXML
    private TextField L_matricula;
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void B_cancelarDonacion(ActionEvent event) {
    }

    @FXML
    private void B_registrarDonacion(ActionEvent event) {
        try {
            String matricula =  L_matricula.getText();
           
            Recurso donacion = new Recurso(L_tituloDonacion.getText(),L_editorialDonacion.getText(), L_autorDonacion.getText(), L_isbnRecurso.getText(), 
                    L_edicionDonacion.getText(), L_estadoDonacion.getText(), Integer.parseInt(L_tomoDonacion.getText()), L_anioRecursoDonacion.getText());
            
            
            
        } catch (Exception e) {
        }
    }

    private boolean buscarUsuario(){
        boolean bandera =false;
        String matricula = L_matricula.getText();
        
        try {
            Estudiante informacionEstudiante = EstudianteDAO.buscarIdEstudiante(matricula);
            
            if (informacionEstudiante.getIdEstudiante() > 0) 
                bandera =true;
            else
                Utilidades.mostrarAlerta("Error", "Matricula no encontrada", Alert.AlertType.ERROR);

        } catch (SQLException ex) {
            Utilidades.mostrarAlerta("Error de conexion", "Hubo un error en el proceso de comunicacion, intentelo mas tarde", Alert.AlertType.ERROR);
        }
        
        return bandera;
    }
    
}
