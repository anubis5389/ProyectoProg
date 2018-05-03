package Ej12;

import java.util.*;

public class GestionArticulos {
	private static ArrayList<Articulo> articulos;
	
	public static void cargarDatos() {
		setArticulos(Fichero.leer());
	}
	public static int guardarDatos() {
		Fichero.escribir(getArticulos());
		
		
		return 3;
	}
	public static Articulo buscarArticulo(String codigo) {
		return getArticulos().get(getArticulos().indexOf(new Articulo(codigo)));
	}
	public static void anadirArticulo(Articulo a) {
		getArticulos().add(a);
	}
	public static void eliminarArticulo(Articulo a) {
		getArticulos().remove(a);
	}
	public static ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public static void setArticulos(ArrayList<Articulo> articulos) {
		GestionArticulos.articulos = articulos;
	}
}
