package com.validadorEgresos;

import java.util.ArrayList;

public class Usuario {

	String nombre;
	String contrasenia;
	Compra compraRevisor;
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
	public Compra getCompraRevisor() {
		return compraRevisor;
	}
	public void darseDeAlta(Compra _compraRevisor) {
		compraRevisor = _compraRevisor;
	}
	
	void verMensajes(BandejaDeMensajes bandeja) {
		bandeja.mostrarMensaje(this);
	}
	
}
