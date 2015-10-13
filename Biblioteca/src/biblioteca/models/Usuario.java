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
public class Usuario {
    
    protected int codigo;
    protected String nombre;
    protected String apellido;
    protected int telefono;
    protected String direccion;

    public Usuario(int codigo, String nombre, String apellido, int telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Usuario(){
        
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public static ObservableList<Usuario> getUsuariosList(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getInt("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                
                usuarios.add(usuario);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "Biblioteca HT", null, "Error al obtener la lista de usuarios", e);
            error.showAndWait();
        }
        
        return usuarios;
    }
}
