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
public class Libro {
    private int codigo;
    private String titulo;
    private String isbn;
    private String editorial;
    private int paginas;

    public Libro(int codigo, String titulo, String isbn, String editorial, int paginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getPaginas() {
        return paginas;
    }
    
    
}
