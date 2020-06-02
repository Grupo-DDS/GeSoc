package com.validadorEgresos;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Object;

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
	
	public void mostrarMensajeAuxiliar(int posicion){
		Mensaje mensaje = mensajes.get(posicion);
		
		imprimirMensaje(mensaje);
	}
	
	void imprimirMensaje(Mensaje mensaje){
		
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
	
	
	private Mensaje find(Compra compra) {
		
	    Mensaje mensaje = null;
	    int index = 0;
	    while(index < mensajes.size()){
	    	if(compra.equals(mensajes.get(index).iscompra())){
	    		mensaje = mensajes.get(index);
	    		return mensaje;
	    	}
	    index++;
	    }
	    return mensaje;
	}
	
	public void mostrarMensaje(Usuario usuario) {
		
		int indexCompras = 0;
		while(indexCompras<usuario.getComprasRevisor().size()) {
			
			Compra compra = usuario.getComprasRevisor().get(indexCompras);
			Mensaje mensaje = find(compra);
			if(mensaje!=null)
				imprimirMensaje(mensaje);
			indexCompras++;
		}
	}
	

	
	
}
