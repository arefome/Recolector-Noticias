package logica;


import java.io.*;
import java.util.ArrayList;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class RecolectorNoticias {
	
	private final String dirElColombiano;
	private final String dirElTiempo;
	private ArrayList<Noticia> notiDeportes;
	private ArrayList<Noticia> notiPolitica;
	private ArrayList<Noticia> notiEntret;
	private ArrayList<Noticia> notiTec;
	private static RecolectorNoticias instancia;
	
	private RecolectorNoticias() {
		dirElColombiano =  "https://www.elcolombiano.com";
		dirElTiempo = "https://www.eltiempo.com";
		notiDeportes = extraerNoticia("/deportes",notiDeportes);
		notiPolitica = extraerNoticia("/colombia/politica",notiPolitica);;
		notiEntret = extraerNoticia("/entretenimiento",notiEntret);
		notiTec = extraerNoticia("/tecnologia",notiTec);
	}
	
	public static RecolectorNoticias getInstance() {
		if(instancia==null) {
			instancia= new RecolectorNoticias();
		}
		return instancia;
	}
	
	private ArrayList<Noticia> extraerNoticia(String categoria,ArrayList<Noticia> noticias ) {
		
		noticias= new ArrayList<Noticia>();
		String categoriaAux;
		
		if (categoria=="/tecnologia") categoriaAux="/tecnosfera";
		else if(categoria == "/colombia/politica") categoriaAux="/politica";
		else categoriaAux=categoria;
		
		try {
			//noticias el tiempo
			Document webElTiempo= Jsoup.connect(dirElTiempo+categoriaAux).get();
			System.out.println(webElTiempo.title());
			Elements titulo= webElTiempo.select("h3[itemprop=headline]");
			Elements Descripcion = webElTiempo.select("div[itemprop = description]");
			Elements link= webElTiempo.select("h3>a");
				
			for(int i=0; i<Descripcion.size();i++) {
				
				noticias.add(new Noticia(titulo.get(i).text(),dirElTiempo+link.get(i).attr("href"), Descripcion.get(i).text(),
						dirElTiempo.substring(12, dirElTiempo.length()-4),categoria));
			}	
			//noticias el colombiano
			Document webElColombiano= Jsoup.connect(dirElColombiano+categoria).get();
			System.out.println(webElColombiano.title());
			Elements h3= webElColombiano.select("h3>a");
					
			for(Element tit : h3) {
				noticias.add(new Noticia(tit.getElementsByClass("priority-content").text(),dirElColombiano+tit.attr("href"),
					tit.getElementsByClass("categoria-noticia").text(),dirElColombiano.substring(12,dirElColombiano.length()-4),categoria));	
			}
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return noticias;
	}
	

	public ArrayList<Noticia> getNotiTec() {
		return notiTec;
	}

	public ArrayList<Noticia> getNotiPolitica() {
		return notiPolitica;
	}

	public ArrayList<Noticia> getNotiEntret() {
		return notiEntret;
		
	}

	public ArrayList<Noticia> getNotiDeportes() {
		return notiDeportes;
	}
}