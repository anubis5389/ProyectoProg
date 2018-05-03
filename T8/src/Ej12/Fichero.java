package Ej12;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Fichero {
	static File fichero;

	public static void setFichero(String nombre) {
		fichero = new File(nombre);
	}
	public static void escribir(ArrayList<Articulo> articulos) {
		try {

			ObjectOutputStream flujoEscritura = new ObjectOutputStream(new FileOutputStream(fichero));
			for(int i=0;i<articulos.size();i++) {
				if(!articulos.isEmpty()) {
					flujoEscritura.writeObject(articulos.get(i));
					flujoEscritura.flush();
					
				}else {
					JOptionPane.showMessageDialog(null, "No hay articulos en la lista");
				}
			}
			flujoEscritura.close();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("file not found");
		}catch(NullPointerException npe){
			npe.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ioexception");
		}


	}
	public static ArrayList<Articulo> leer() {
		ArrayList<Articulo> listaArticulos=null ;
		ObjectInputStream flujoLectura=null;
		try {
			flujoLectura = new ObjectInputStream(new FileInputStream(fichero));
			
			while(true) {
				Articulo a = (Articulo)flujoLectura.readObject();
				listaArticulos.add(a);
			}
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				flujoLectura.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("excepcion al cerrar el flujo");
			}
		}
		return listaArticulos;
	}
}