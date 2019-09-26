package logica;

import java.io.Serializable;

public class Noticia implements Serializable{
	//Atributos
	
	
	private String titulo;
	private String dirEnlace;
	private String descripcion;
	private String fuente;
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

	
