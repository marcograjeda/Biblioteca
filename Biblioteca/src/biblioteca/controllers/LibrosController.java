/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.controllers;

import biblioteca.Biblioteca;
import biblioteca.models.Libro;
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
 * @author informatica
 */
public class LibrosController implements Initializable {
    
    @FXML
    private TableView<Libro> tbvLibros;
    @FXML
    private TableColumn<Libro, String> tbcID;
    @FXML
    private TableColumn<Libro, String> tbcTitulo;
    
    private Biblioteca biblio;

    public void setBiblio(Biblioteca biblio) {
        this.biblio = biblio;
        //tbvLibros.setItems(biblio.getLibrosList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //tbcID.setCellValueFactory(new PropertyValueFactory<Libro, String>("codigo"));
        //tbcTitulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        
        //tbvLibros.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }    
}
