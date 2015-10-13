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
public class Prestamo {
    protected int codigoEjemplar;
    protected int codigoUsuario;
    protected String fechaPrestamo;
    protected String fechaDevolucion; //formato fechas yyyy/mm/dd

    public Prestamo(int codigoEjemplar, int codigoUsuario, String fechaPrestamo, String fechaDevolucion) {
        this.codigoEjemplar = codigoEjemplar;
        this.codigoUsuario = codigoUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {
    }

    public int getCodigoEjemplar() {
        return codigoEjemplar;
    }

    public void setCodigoEjemplar(int codigoEjemplar) {
        this.codigoEjemplar = codigoEjemplar;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
