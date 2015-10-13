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

    public Libro() {
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    
}
