package Ej12;

import java.io.*;

public class Articulo implements Serializable{
	private String codigo;
	private double precio;
	private int cantidad;
	public Articulo(String codigo, int cantidad ,double precio) {
		this.codigo=codigo;
		this.cantidad=cantidad;
		this.precio=precio;
	}
	public Articulo(String codigo) {
		this.codigo=codigo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
