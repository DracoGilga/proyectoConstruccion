/*
 * CU03 Registrar usuario
 * Autor: Álvaro Barradas Fernández
 * Fecha de creación: 10/12/2022
 * Descripción: Ventana para el registro de docente en el sistema
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.CarreraDAO;
import sistemabibliotecario.DAO.UsuarioBibliotecarioDAO;
import sistemabibliotecario.DAO.RegionDAO;
import sistemabibliotecario.POJO.Carrera;
import sistemabibliotecario.POJO.UsuarioBibliotecario;
import sistemabibliotecario.POJO.Region;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;

public class RegistrarUsuarioBibliotecario implements Initializable {

    @FXML
    private ComboBox<Region> CB_region;
    @FXML
    private TextField TF_nombre;
    @FXML
    private TextField TF_apellidoPaterno;
    @FXML
    private TextField TF_apellidoMaterno;
    @FXML
    private TextField TF_direccion;
    @FXML
    private Label L_errorNumeroPersonal;
    @FXML
    private Label L_errorNombre;
    @FXML
    private Label L_errorApellidoPaterno;
    @FXML
    private Label L_errorApellidoMaterno;
    @FXML
    private Label L_errorDireccion;
    @FXML
    private Label L_errorRegion;
    @FXML
    private TextField TF_matriculaNumeroPersonal;
    @FXML
    private ComboBox<Carrera> CB_carrera;
    @FXML
    private Label L_errorCarrera;
    
    private ObservableList<Region> listaRegiones;
    private ObservableList<Carrera> listaCarreras;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        cargarListaRegiones();
        cargarListaCarreras();
        
    }    

    @FXML
    private void clicRegresar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }

    @FXML
    private void clicRegistrar(ActionEvent event) 
    {
        
        L_errorNumeroPersonal.setText("");
        L_errorNombre.setText("");
        L_errorApellidoPaterno.setText("");
        L_errorApellidoMaterno.setText("");
        L_errorDireccion.setText("");
        L_errorRegion.setText("");
        L_errorCarrera.setText("");
        String idUsuarioBibliotecario = TF_matriculaNumeroPersonal.getText();
        String nombre = TF_nombre.getText();
        String apellidoPaterno = TF_apellidoPaterno.getText();
        String apellidoMaterno = TF_apellidoMaterno.getText();
        String direccion = TF_direccion.getText();
        int validacionRegion = CB_region.getSelectionModel().getSelectedIndex();
        int validacionCarrera = CB_carrera.getSelectionModel().getSelectedIndex();
        boolean valido = true;
        
        if(idUsuarioBibliotecario.isEmpty())
        {
            
            valido = false;
            L_errorNumeroPersonal.setText("Es necesario el numero personal");
            
        }
        
        if(nombre.isEmpty())
        {
            
            valido = false;
            L_errorNombre.setText("Es necesario el nombre");
            
        }
        
        if(apellidoPaterno.isEmpty())
        {
            
            valido = false;
            L_errorApellidoPaterno.setText("Es necesario el apellido paterno");
            
        }
        
        if(apellidoMaterno.isEmpty())
        {
            
            valido = false;
            L_errorApellidoMaterno.setText("Es necesario el apellido materno");
            
        }
        
        if(direccion.isEmpty())
        {
            
            valido = false;
            L_errorDireccion.setText("Es necesaria la direccion");
            
        }

        if(validacionRegion == -1)
        {
            valido = false;
            L_errorRegion.setText("Es necesaria la region");  
        }
        
        if(validacionCarrera == -1)
        {
            valido = false;
            L_errorCarrera.setText("Es necesaria la carrera");  
        }
        
        if(valido)
        {
            int idRegion = CB_region.getSelectionModel().getSelectedItem().getIdRegion();
            int idCarrera = CB_carrera.getSelectionModel().getSelectedItem().getIdCarrera();
            UsuarioBibliotecario usuarioBibliotecario = new UsuarioBibliotecario();
            usuarioBibliotecario.setIdUsuarioBibliotecario(idUsuarioBibliotecario);
            usuarioBibliotecario.setNombre(nombre);
            usuarioBibliotecario.setApellidoPaterno(apellidoPaterno);
            usuarioBibliotecario.setApellidoMaterno(apellidoMaterno);
            usuarioBibliotecario.setDireccion(direccion);
            usuarioBibliotecario.setIdRegion(idRegion);
            usuarioBibliotecario.setIdCarrera(idCarrera);
            guardarRegistroNuevo(usuarioBibliotecario);
            TF_matriculaNumeroPersonal.setText("");
            TF_nombre.setText("");
            TF_apellidoPaterno.setText("");
            TF_apellidoMaterno.setText("");
            TF_direccion.setText("");
            CB_region.setValue(null);
            CB_carrera.setValue(null);
        }
        
    }

    private void cargarListaRegiones() 
    {
        
        listaRegiones = FXCollections.observableArrayList();
        try
        {
            
            ArrayList<Region> regionessBD = RegionDAO.obtenerRegiones();
            listaRegiones.addAll(regionessBD);
            CB_region.setItems(listaRegiones);
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
        }
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) TF_nombre.getScene().getWindow();
        escenarioPrincipal.close();
        
    }

    private void guardarRegistroNuevo(UsuarioBibliotecario usuarioNuevo) 
    {
        
       try
        {
            
            ResultadoOperacion resultadoGuardar = UsuarioBibliotecarioDAO.registrarUsuarioBibliotecario(usuarioNuevo);
            if(!resultadoGuardar.isError())
            {
                
                Utilidades.mostrarAlerta("Usuario registrado", resultadoGuardar.getMensaje(), Alert.AlertType.INFORMATION);
                
            } else
            {
                
                Utilidades.mostrarAlerta("Error al registrar usuario", resultadoGuardar.getMensaje(), Alert.AlertType.ERROR);
                
            }
            
        } catch(SQLException ex)
        {
            
            Utilidades.mostrarAlerta("Error de conexión", ex.getMessage(), Alert.AlertType.ERROR);
            
        } 
        
    }

    private void cargarListaCarreras() 
    {
        
        listaCarreras = FXCollections.observableArrayList();
        try
        {
            
            ArrayList<Carrera> carrerasBD = CarreraDAO.obtenerCarreras();
            listaCarreras.addAll(carrerasBD);
            CB_carrera.setItems(listaCarreras);
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
        }
        
    }
    
}
