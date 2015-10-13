/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controllers;

import biblioteca.Biblioteca;
import biblioteca.models.Ejemplar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Marco
 */
public class EjemplarController implements Initializable {
    @FXML
    private TableView<Ejemplar> tbvEjemplares;
    @FXML
    private TableColumn<Ejemplar, String> tbcID;
    
    private Biblioteca biblio;
    public void setBiblio(Biblioteca biblio) {
        this.biblio = biblio;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
