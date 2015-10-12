/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.controllers.UsuariosController;
import biblioteca.models.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class Biblioteca extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
    
    public Biblioteca(){
        usuariosList.add(new Usuario(123, "Marco", "Lopez", 12345678, "Guatemala"));
        usuariosList.add(new Usuario(321, "Mario", "Perez", 78954632, "Guatemala"));
        usuariosList.add(new Usuario(456, "Alfredo", "Zidane", 45669873, "Guatemala"));
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Biblioteca HT");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showUsuarios();
    }

    public void showUsuarios(){
    try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Biblioteca.class.getResource("views/Usuarios.fxml"));
            AnchorPane usuariosPane = (AnchorPane) loader.load();
            UsuariosController controller = loader.getController();
            controller.setBiblio(this);
            rootLayout.setCenter(usuariosPane);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Usuario> getUsuariosList() {
        return usuariosList;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
