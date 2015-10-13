/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.models;

/**
 *
 * @author Marco
 */
public class Usuario {
        private int idUsuario;
	private String nombre;
		
	public Usuario(int var1, String var2) {
		nombre = var2;
		idUsuario = var1;
	}
	

	//Get y Set
	//SET
	public void setIdUsuario(int valor) {
		idUsuario = valor;
	}
	
	public void setNombreUsuario(String valor) {
		nombre = valor;
	}
	

	
	//GET
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getNombreUsuario() {
		return nombre;
	}
	
        

    
    
}
