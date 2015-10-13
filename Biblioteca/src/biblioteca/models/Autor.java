/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.models;

import biblioteca.helpers.DBHelper;
import biblioteca.helpers.Dialogs;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Marco
 */
public class Autor {
    private int codigo;
    private String nombre;

    public Autor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Autor() {
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public static ObservableList<Autor> getAutoresList(){
        ObservableList<Autor> autores = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM autor";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Autor autor = new Autor();
                
                autor.setCodigo(rs.getInt("codigo"));
                autor.setNombre(rs.getString("nombre"));
                
                autores.add(autor);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al obtener la lista de autores", e);
            error.showAndWait();
        }
        
        return autores;
    }
}
