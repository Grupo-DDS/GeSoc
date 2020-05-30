package com.validadorEgresos;

import java.util.ArrayList;

public class BandejaDeMensajes {
	static ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	public void agregarMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	public static ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}
	public static void setMensajes(ArrayList<Mensaje> mensajes) {
		BandejaDeMensajes.mensajes = mensajes;
	}
	
	public void mostrarMensaje(int posicion){
		Mensaje mensaje = mensajes.get(posicion);
		
		if(mensaje.iscantidadPresupuestosIndicada())
			{System.out.println("Cantidad presupestos indicada TRUE");}
		else
			{System.out.println("Cantidad presupestos indicada FALSE");}
		
		if(mensaje.ispresupuestoElegido())
			{System.out.println("Presupesto elegido TRUE");}
		else
			{System.out.println("Presupesto elegido FALSE");}
		
		if(mensaje.isseleccionProveedor())
			{System.out.println("Seleccion proveedor TRUE");}
		else
			{System.out.println("Seleccion proveedor FALSE");}
	}
	
	
}
