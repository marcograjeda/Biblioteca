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
        private String rango;
	private String nombre;
	private String clave;
		
	public Usuario(int var1, String var4, String var2, String var3) {
		nombre = var2;
                rango = var4;
		idUsuario = var1;
		clave = var3;
	}
	

	//Get y Set
	//SET
	public void setIdUsuario(int valor) {
		idUsuario = valor;
	}
	
	public void setNombreUsuario(String valor) {
		nombre = valor;
	}
	
	public void setClaveUsuario(String valor) {
		clave = valor;
	}
	
	//GET
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getNombreUsuario() {
		return nombre;
	}
	
	public String getClaveUsuario() {
		return clave;
	}

        public String getRangoUsuario() {
		return rango;
	}
        
	//GET GENERAL	
	public String getDatosUsuario() {
		String g2 = "\n ID: " + idUsuario;
		String g1 = "\n Nombre: " + nombre + "\n";

		return g2 + g1;
	}
    
    
}
