/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controllers;

import biblioteca.Biblioteca;
import biblioteca.Biblioteca.CRUDOperation;
import biblioteca.models.Autor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class IngresarAutorController implements Initializable {

    private Biblioteca biblio;

    public void setBiblio(Biblioteca biblio) {
        this.biblio = biblio;
    }
    @FXML
    private TextField txtNombre;
    
    private Stage dialogStage;
    private boolean presionadoOk;
    private Biblioteca.CRUDOperation operacion;
    private Autor autor;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setOperacion(Biblioteca.CRUDOperation operacion) {
        this.operacion = operacion;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
        
        txtNombre.setText(autor.getNombre());
    }
    
    public boolean fuePresionadoOk(){
        return this.presionadoOk;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
