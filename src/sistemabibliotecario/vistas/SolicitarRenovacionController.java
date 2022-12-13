package sistemabibliotecario.vistas;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemabibliotecario.DAO.PrestamoDAO;
import sistemabibliotecario.DAO.RecursoDAO;
import sistemabibliotecario.DAO.UsuarioBibliotecarioDAO;
import sistemabibliotecario.POJO.Prestamo;
import sistemabibliotecario.POJO.UsuarioBibliotecario;
import sistemabibliotecario.POJO.Recurso;
import sistemabibliotecario.POJO.ResultadoOperacion;
import sistemabibliotecario.utills.Utilidades;

public class SolicitarRenovacionController implements Initializable {

    @FXML
    private TextField TF_nombre;
    @FXML
    private TextField TF_apellidoPaterno;
    @FXML
    private TextField TF_apellidoMaterno;
    @FXML
    private TextField TF_direccion;
    @FXML
    private TextField TF_titulo;
    @FXML
    private TextField TF_autor;
    @FXML
    private TextField TF_editorial;
    @FXML
    private TextField TF_fechaInicio;
    @FXML
    private TextField TF_matriculaNumeroPersonal;
    @FXML
    private ComboBox<Prestamo> CB_prestamosActivos;
    @FXML
    private DatePicker DP_fechaFin;
    @FXML
    private TextField TF_edicion;
    @FXML
    private TextField TF_isbn;
    @FXML
    private TextField TF_tomo;
    @FXML
    private TextField TF_fechaFin;
    @FXML
    private Button BTN_registrar;
    
    private ObservableList<Prestamo> listaPrestamos;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        BTN_registrar.setDisable(true);
    }    

    @FXML
    private void clicBuscarUsuario(ActionEvent event) 
    {
        TF_nombre.setText("");
        TF_apellidoPaterno.setText("");
        TF_apellidoMaterno.setText("");
        TF_direccion.setText("");
        TF_titulo.setText("");
        TF_autor.setText("");
        TF_editorial.setText("");
        TF_edicion.setText("");
        TF_isbn.setText("");
        TF_tomo.setText("");
        TF_fechaInicio.setText("");
        TF_fechaFin.setText("");
        CB_prestamosActivos.setValue(null);
        String matriculaNumeroPersonal = TF_matriculaNumeroPersonal.getText();
        UsuarioBibliotecario usuarioObtenido = new UsuarioBibliotecario();
        UsuarioBibliotecarioDAO usuarioBibliotecarioDao = new UsuarioBibliotecarioDAO();
        try
        {
            usuarioObtenido = usuarioBibliotecarioDao.obtenerUsuarioPorId(matriculaNumeroPersonal);
            if(usuarioObtenido != null)
            {
                TF_nombre.setText(usuarioObtenido.getNombre());
                TF_apellidoPaterno.setText(usuarioObtenido.getApellidoPaterno());
                TF_apellidoMaterno.setText(usuarioObtenido.getApellidoMaterno());
                TF_direccion.setText(usuarioObtenido.getDireccion());
                cargarListaPrestamos(matriculaNumeroPersonal);

            } else
            {
                Utilidades.mostrarAlerta("Error", "No se encontró ningun usuario con estas credenciales", Alert.AlertType.ERROR);
                TF_matriculaNumeroPersonal.setText("");
                BTN_registrar.setDisable(true);
            }
        } catch(SQLException ex)
        {
            Utilidades.mostrarAlerta("Error", "Error al recuperar los datos", Alert.AlertType.ERROR);
        }
        
    }


    @FXML
    private void clicRegistrar(ActionEvent event) 
    {
        String fechaVerificacion = DP_fechaFin.getValue().toString();
        if(!fechaVerificacion.isEmpty())
        {
            Prestamo prestamoRenovado = new Prestamo();
            prestamoRenovado.setIdUsuarioBibliotecario(TF_matriculaNumeroPersonal.getText());
            prestamoRenovado.setFechaInicio(TF_fechaInicio.getText());
            prestamoRenovado.setFechaFin(DP_fechaFin.getValue().toString());
            guardarPrestamoRenovado(prestamoRenovado);
        } else
        {
            Utilidades.mostrarAlerta("No selecciono fecha nueva", "Debe seleccionar una fecha para renovar la anterior", Alert.AlertType.INFORMATION);
        }
        
    }

    @FXML
    private void clicCancelar(ActionEvent event) 
    {
        
        cerrarVentana();
        
    }
    @FXML
    private void clicBuscarPrestamo(ActionEvent event) 
    {
        TF_titulo.setText("");
        TF_autor.setText("");
        TF_editorial.setText("");
        TF_edicion.setText("");
        TF_isbn.setText("");
        TF_tomo.setText("");
        TF_fechaInicio.setText("");
        TF_fechaFin.setText("");
        int idRecurso = CB_prestamosActivos.getSelectionModel().getSelectedItem().getIdRecurso();
        String idUsuarioBibliotecario = TF_matriculaNumeroPersonal.getText();
        Prestamo prestamoObtenido = new Prestamo();
        PrestamoDAO prestamoDao = new PrestamoDAO();
        Recurso recursoObtenido = new Recurso();
        RecursoDAO recursoDao = new RecursoDAO();
        try
        {
            recursoObtenido = recursoDao.obtenerRecursoPorId(idRecurso);
            prestamoObtenido = prestamoDao.obtenerPrestamoPorUsuario(idUsuarioBibliotecario);
            if(recursoObtenido != null)
            {
                TF_titulo.setText(recursoObtenido.getTitulo());
                TF_autor.setText(recursoObtenido.getAutor());
                TF_editorial.setText(recursoObtenido.getEditorial());
                TF_edicion.setText(recursoObtenido.getEdicion());
                TF_isbn.setText(recursoObtenido.getIsbn());
                TF_tomo.setText(Integer.toString(recursoObtenido.getTomo()));
                TF_fechaInicio.setText(prestamoObtenido.getFechaInicio());
                TF_fechaFin.setText(prestamoObtenido.getFechaFin());
                BTN_registrar.setDisable(false);
                
            }
        } catch(SQLException ex)
        {
            Utilidades.mostrarAlerta("Error", "Error al recuperar los datos", Alert.AlertType.ERROR);
        }
        
    }
    
    private void cerrarVentana()
    {
        
        Stage escenarioPrincipal = (Stage) TF_nombre.getScene().getWindow();
        escenarioPrincipal.close();
        
    }
    
    private void cargarListaPrestamos(String idUsuarioBibliotecario)
    {
        
        listaPrestamos = FXCollections.observableArrayList();
        try
        {
            
            ArrayList<Prestamo> prestamosBD = PrestamoDAO.obtenerPrestamosActivos(idUsuarioBibliotecario);
            listaPrestamos.addAll(prestamosBD);
            CB_prestamosActivos.setItems(listaPrestamos);
            
        } catch(SQLException ex)
        {
            
            ex.printStackTrace();
            
        }
        
    }

    private void guardarPrestamoRenovado(Prestamo prestamoRenovado) 
    {
        
        try
        {
            
            ResultadoOperacion resultadoGuardar = PrestamoDAO.registrarRenovacion(prestamoRenovado);
            if(!resultadoGuardar.isError()){
                Utilidades.mostrarAlerta("Exito en la operacion", 
                        "Fecha final del prestamo extendida con exito", Alert.AlertType.INFORMATION);
                cerrarVentana();
            } else{
                Utilidades.mostrarAlerta("Error en la operacion", 
                        "No se pudo modificar la fecha de fin del prestamo", Alert.AlertType.ERROR);
            }
            
        } catch (SQLException e) 
            {
                Utilidades.mostrarAlerta("Error de conexión", "Por el momento no hay conexion con la base de datos", 
                        Alert.AlertType.ERROR);
            }
        
    }
}
