/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.controllers.AutoresController;
import biblioteca.controllers.EjemplarController;
import biblioteca.controllers.IngresarAutorController;
import biblioteca.controllers.LibrosController;
import biblioteca.controllers.RootLayoutController;
import biblioteca.controllers.UsuariosController;
import biblioteca.helpers.Dialogs;
import biblioteca.models.Autor;
import biblioteca.models.Libro;
import biblioteca.models.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class Biblioteca extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
    private ObservableList<Autor> autoresList = FXCollections.observableArrayList();
    private ObservableList<Libro> librosList = FXCollections.observableArrayList();
    public enum CRUDOperation {None, Create, Read, Update, Delete};
    
    public Biblioteca(){
        usuariosList.add(new Usuario(123, "Marco", "Lopez", 12345678, "Guatemala"));
        usuariosList.add(new Usuario(321, "Mario", "Perez", 78954632, "Guatemala"));
        usuariosList.add(new Usuario(456, "Alfredo", "Zidane", 45669873, "Guatemala"));
        autoresList.add(new Autor(1, "Dante"));
        librosList.add(new Libro(147, "Inferno", "147asdf", "totito", 789));
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Biblioteca HT");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController controller = loader.getController();
            controller.setBiblio(this);
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
        this.usuariosList = Usuario.getUsuariosList();
    }

    public void mostrarUsuarios(){
    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/Usuarios.fxml"));
            AnchorPane usuariosPane = (AnchorPane) loader.load();
            UsuariosController controller = loader.getController();
            controller.setBiblio(this);
            rootLayout.setCenter(usuariosPane);
            
        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
    }
    
    public void mostrarAutores(){
    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/Autores.fxml"));
            AnchorPane autoresPane = (AnchorPane) loader.load();
            AutoresController controller = loader.getController();
            controller.setBiblio(this);
            rootLayout.setCenter(autoresPane);
            
        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
    }
    
    public void mostrarLibros(){
    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/Libros.fxml"));
            AnchorPane librosPane = (AnchorPane) loader.load();
            LibrosController controller = loader.getController();
            controller.setBiblio(this);
            rootLayout.setCenter(librosPane);
            
        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
    }
    
    public void mostrarEjemplares(){
    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/Ejemplares.fxml"));
            AnchorPane librosPane = (AnchorPane) loader.load();
            EjemplarController controller = loader.getController();
            controller.setBiblio(this);
            rootLayout.setCenter(librosPane);
            
        } catch (Exception e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
    }
    
    public boolean mostrarEditarAutor(Autor autor, CRUDOperation operacion){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/IngresarAutor.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Autor");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene escena = new Scene(page);
            dialogStage.setScene(escena);
            dialogStage.setResizable(false);
            IngresarAutorController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setOperacion(operacion);
            controller.setAutor(autor);
            
            dialogStage.showAndWait();
            
            return controller.fuePresionadoOk();
            
        }
        catch(Exception e){
            e.printStackTrace();
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public ObservableList<Autor> getAutoresList() {
        return autoresList;
    }

    public ObservableList<Libro> getLibrosList() {
        return librosList;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
