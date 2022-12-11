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
import sistemabibliotecario.DAO.CarreraDAO;
import sistemabibliotecario.DAO.EstudianteDAO;
import sistemabibliotecario.DAO.RegionDAO;
import sistemabibliotecario.POJO.Carrera;
import sistemabibliotecario.POJO.Estudiante;
import sistemabibliotecario.POJO.Region;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;


public class RegistrarAlumnoController implements Initializable {

    @FXML
    private TextField tf_Matricula;
    @FXML
    private TextField tf_Nombre;
    @FXML
    private TextField tf_ApellidoPaterno;
    @FXML
    private TextField tf_ApellidoMaterno;
    @FXML
    private TextField tf_Direccion;
    @FXML
    private ComboBox<Carrera> cb_Carrera;
    @FXML
    private ComboBox<Region> cb_Region;
    
    private ObservableList<Carrera> listaCarreras;
    private ObservableList<Region> listaRegiones;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        cargarListaCarreras();
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
        
        String matricula = tf_Matricula.getText();
        String nombre = tf_Nombre.getText();
        String apellidoPaterno = tf_ApellidoPaterno.getText();
        String apellidoMaterno = tf_ApellidoMaterno.getText();
        String direccion = tf_Direccion.getText();
        int idCarrera = cb_Carrera.getSelectionModel().getSelectedItem().getIdCarrera();
        int idRegion = cb_Region.getSelectionModel().getSelectedItem().getIdRegion();
        boolean valido = true;
        
        if(valido)
        {
            
          Estudiante estudiante = new Estudiante();
          estudiante.setMatricula(matricula);
          estudiante.setNombre(nombre);
          estudiante.setApellidoPaterno(apellidoPaterno);
          estudiante.setApellidoMaterno(apellidoMaterno);
          estudiante.setDireccion(direccion);
          estudiante.setIdCarrera(idCarrera);
          estudiante.setIdRegion(idRegion);
          guardarRegistroNuevo(estudiante);
            
        }
        
        
    }

    private void cargarListaCarreras() 
    {
        
        listaCarreras = FXCollections.observableArrayList();
        try
        {
            
            ArrayList<Carrera> carrerasBD = CarreraDAO.obtenerCarreras();
            listaCarreras.addAll(carrerasBD);
            cb_Carrera.setItems(listaCarreras);
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
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

    private void guardarRegistroNuevo(Estudiante estudianteNuevo) 
    {
        
        try
        {
            
            ResultadoOperacion resultadoGuardar = EstudianteDAO.registrarEstudiante(estudianteNuevo);
            if(!resultadoGuardar.isError())
            {
                
                Utilidades.mostrarAlerta("Alumno registrado", resultadoGuardar.getMensaje(), Alert.AlertType.INFORMATION);
                cerrarVentana();
                
            } else
            {
                
                Utilidades.mostrarAlerta("Error al registrar alumno", resultadoGuardar.getMensaje(), Alert.AlertType.ERROR);
                
            }
            
        } catch(SQLException ex)
        {
            
            Utilidades.mostrarAlerta("Error de conexión", ex.getMessage(), Alert.AlertType.ERROR);
            
        }
        
    }
    
}