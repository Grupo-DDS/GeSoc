package com.validadorEgresos;

import java.util.ArrayList;

public class Usuario {

	String nombre;
	String contrasenia;
	static ArrayList<Compra> comprasRevisor = new ArrayList<Compra>();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public ArrayList<Compra> getComprasRevisor() {
		return comprasRevisor;
	}
	public void setComprasRevisor(ArrayList<Compra> comprasRevisor) {
		Usuario.comprasRevisor = comprasRevisor;
	}
	
	void verMensajes(BandejaDeMensajes bandeja) {
		bandeja.mostrarMensaje(this);
	}
	
	public void agregarCompraRevisor(Compra compra) {
		comprasRevisor.add(compra);
	}
}
