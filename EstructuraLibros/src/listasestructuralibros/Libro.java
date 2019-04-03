
package listasestructuralibros;

/**
 *Ester Guamuch
 * 0901-17-998
 */


public class Libro {
           private String titulo;
	private String autor;
	private String isbn;
        
        // Constructo Libro, contiene los datoa a utilizar
	public Libro(String titulo, String autor, String isbn) {
		this.titulo=titulo;
		this.autor=autor;
		this.isbn=isbn;
	}

        // Procedimientos para insertar y retornar valores o datos
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
	
                     
}
