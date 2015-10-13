/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.models;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Marco
 */
public class Prestamo {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");	
	
	private int idPrestamo;
	private String idLibro;
	private String fechaInicio;
	private String fechaFin;
	private String fechaEntrega = null;
	private boolean devuelto = false;
	
	public Prestamo(int var0, String var2, String var3, String var4, boolean jaja) {
		idPrestamo = var0;
		idLibro = var2;
		fechaInicio = var3;
		fechaFin = var4;
                devuelto = jaja;
	}
	
	//Set y get
	//SET
	public void setIdPrestamo(int valor) {
		idPrestamo = valor;
	}
	
	
	public void setIdLibro(String valor) {
		idLibro = valor;
	}
	
	public void setFechaInicio(String valor) {
		fechaInicio = valor;
	}
	
	public void setFechaFin(String valor) {
		fechaFin = valor;
	}
	
	public void setFechaEntrega(String valor) {
		fechaEntrega = valor;
	}
	
	public void setDevolucion(boolean valor) {
		devuelto = valor;
	}
	
	//GET
	public int getIdPrestamo() {
		return idPrestamo;
	}
	
	
	public String getIdLibro() {
		return idLibro;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	
	public boolean getDevolucion() {
		return devuelto;
	}
	
	
	
}
