package logica;

public class Noticia{
	//Atributos
	
	/**
	 * Atributo que almacena el titulo de la noticia 
	 */
	private String titulo;

	/**
	 * Atributo que almacena el url de la noticia 
	 */
	private String dirEnlace;
	/**
	 * Atributo que almacena la descripcion de la noticia 
	 */
	private String descripcion;
	/**
	 * Atributo que almacena el nombre del portal web donde se extrae la noticia 
	 */
	private String fuente;
	/**
	 * Atributo que almacena la categoria de la noticia 
	 */
	private String categoria;
	
	// Metodos
	/**
	 * constructor parametrico
	 * @param t identificador noticia
	 * @param dir direccion de enlace
	 * @param d descripcion noticia
	 * @param f nombre fuente
	 * @param c categoria
	 */
	public Noticia(String t, String dir,String d,String f,String c) {
		titulo=t;
		dirEnlace=dir;
		descripcion=d;
		fuente=f;
		categoria=c;
	}
	//Getters and Setters Noticia
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirEnlace() {
		return dirEnlace;
	}

	public void setDirLogo(String dirLogo) {
		this.dirEnlace = dirLogo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}

	
