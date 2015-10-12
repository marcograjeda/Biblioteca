/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controllers;

import biblioteca.Biblioteca;
import biblioteca.models.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class UsuariosController implements Initializable {
    @FXML
    private TableView<Usuario> tbvUsuarios;
    @FXML
    private TableColumn<Usuario, String> tbcID;
    @FXML
    private TableColumn<Usuario, String> tbcNombre;
    @FXML
    private TableColumn<Usuario, String> tbcApellido;
    @FXML
    private TableColumn<Usuario, String> tbcTelefono;
    @FXML
    private TableColumn<Usuario, String> tbcDireccion;
    
    private Biblioteca biblio;

    public void setBiblio(Biblioteca biblio) {
        this.biblio = biblio;
        tbvUsuarios.setItems(biblio.getUsuariosList());
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOO
        tbcID.setCellValueFactory(new PropertyValueFactory<Usuario, String>("codigo"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        tbcApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellido"));
        tbcTelefono.setCellValueFactory(new PropertyValueFactory<Usuario, String>("telefono"));
        tbcDireccion.setCellValueFactory(new PropertyValueFactory<Usuario, String>("direccion"));
    }    
    
}
