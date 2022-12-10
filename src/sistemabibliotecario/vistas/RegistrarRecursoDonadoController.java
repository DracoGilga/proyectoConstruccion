/*
 * 
 * 
 */
package sistemabibliotecario.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegistrarRecursoDonadoController implements Initializable {

    @FXML
    private Button btn_Cancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
