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
public class Ejemplar {
    private int codigo;
    private int codigoLibro;
    private String localizacion;

    public Ejemplar(int codigo, int codigoLibro, String localizacion) {
        this.codigo = codigo;
        this.codigoLibro = codigoLibro;
        this.localizacion = localizacion;
    }

    public Ejemplar() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    
}
