/*
 * 
 * 
 */
package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.DocenteDAO;
import sistemabibliotecario.DAO.RegionDAO;
import sistemabibliotecario.POJO.Docente;
import sistemabibliotecario.POJO.Region;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;

public class RegistrarDocenteController implements Initializable {

    @FXML
    private ComboBox<Region> cb_Region;
    @FXML
    private TextField tf_NumeroPersonal;
    @FXML
    private TextField tf_Nombre;
    @FXML
    private TextField tf_ApellidoPaterno;
    @FXML
    private TextField tf_ApellidoMaterno;
    @FXML
    private TextField tf_Direccion;
    
    private ObservableList<Region> listaRegiones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        cargarListaRegiones();
        
    }    

    @FXML
    private void clicRegresar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }

    @FXML
    private void clicRegistrar(ActionEvent event) 
    {
        
        String numeroPersonal = tf_NumeroPersonal.getText();
        String nombre = tf_Nombre.getText();
        String apellidoPaterno = tf_ApellidoPaterno.getText();
        String apellidoMaterno = tf_ApellidoMaterno.getText();
        String direccion = tf_Direccion.getText();
        int idRegion = cb_Region.getSelectionModel().getSelectedItem().getIdRegion();
        boolean valido = true;
        
        if(valido)
        {
            
          Docente docente = new Docente();
          docente.setNumeroPersonal(numeroPersonal);
          docente.setNombre(nombre);
          docente.setApellidoPaterno(apellidoPaterno);
          docente.setApellidoMaterno(apellidoMaterno);
          docente.setDireccion(direccion);
          docente.setIdRegion(idRegion);
          guardarRegistroNuevo(docente);
            
        }
        
    }

    private void cargarListaRegiones() 
    {
        
        listaRegiones = FXCollections.observableArrayList();
        try
        {
            
            ArrayList<Region> regionessBD = RegionDAO.obtenerRegiones();
            listaRegiones.addAll(regionessBD);
            cb_Region.setItems(listaRegiones);
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
        }
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) tf_Nombre.getScene().getWindow();
        escenarioPrincipal.close();
        
    }

    private void guardarRegistroNuevo(Docente docenteNuevo) 
    {
        
       try
        {
            
            ResultadoOperacion resultadoGuardar = DocenteDAO.registrarDocente(docenteNuevo);
            if(!resultadoGuardar.isError())
            {
                
                Utilidades.mostrarAlerta("Docente registrado", resultadoGuardar.getMensaje(), Alert.AlertType.INFORMATION);
                cerrarVentana();
                
            } else
            {
                
                Utilidades.mostrarAlerta("Error al registrar docente", resultadoGuardar.getMensaje(), Alert.AlertType.ERROR);
                
            }
            
        } catch(SQLException ex)
        {
            
            Utilidades.mostrarAlerta("Error de conexión", ex.getMessage(), Alert.AlertType.ERROR);
            
        } 
        
    }
    
}
