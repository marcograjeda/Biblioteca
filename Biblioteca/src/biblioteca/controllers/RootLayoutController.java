/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controllers;

import biblioteca.Biblioteca;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Marco
 */
public class RootLayoutController implements Initializable{

    private Biblioteca biblio;

    public void setBiblio(Biblioteca biblio) {
        this.biblio = biblio;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
    @FXML
    private void salirAplicacion(){
        System.exit(0);
    }
    
    @FXML
    private void mostrarUsuariosCRUD(){
        this.biblio.mostrarUsuarios();
    }
    
    @FXML
    private void mostrarAutoresCRUD(){
        this.biblio.mostrarAutores();
    }
    
    @FXML
    private void mostrarLibrosCRUD(){
        this.biblio.mostrarLibros();
    }
    
    @FXML
    private void mostrarEjemplares(){
        this.biblio.mostrarEjemplares();
    }
}
