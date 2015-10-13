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
public class Editorial {
        private int idEditorial;
	private String nombre;
		
	public Editorial(int var1, String var2) {
		nombre = var2;
		idEditorial = var1;
	}
	

	//Get y Set
	//SET
	public void setIdEditorial(int valor) {
		idEditorial = valor;
	}
	
	public void setNombreEditorial(String valor) {
		nombre = valor;
	}

	//GET
	public int getIdEditorial() {
		return idEditorial;
	}
	
	public String getNombreEditorial() {
		return nombre;
	}

    
}
