package com.validadorEgresos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ValidadorCompras {
	static Mensaje mensaje;
	static int presupuestosRequeridos = 3;
	
	public static void verificarCantidad(Compra compra){
		if(!compra.isRequierePresupuestos())
			mensaje.setcantidadPresupuestosIndicada(true);
		else
			mensaje.setcantidadPresupuestosIndicada(presupuestosRequeridos == compra.cantidadDePresupuestos());
		
	}
	public static void verificarPresupuestoElegido(Compra compra){
		boolean set = compra.getPresupuestos().contains(compra.getPresupuestoElegido());
		mensaje.setpresupuestoElegido(set);
	}
	public static void verificarSeleccionProveedor(Compra compra){
		Comparator <Presupuesto> comparador = new Comparator<Presupuesto>(){
			@Override
			public int compare(Presupuesto presupuesto1,Presupuesto presupuesto2) {
				if (presupuesto1.getMonto()>presupuesto2.getMonto())
					return 1;
				else
					return -1;
			}
		};
		Presupuesto presMin = Collections.min(compra.getPresupuestos(), comparador);
		boolean set = compra.getPresupuestoElegido().equals(presMin);
		mensaje.setseleccionProveedor(set);
	}
	
	
	public static void validar(Compra compra,BandejaDeMensajes bandeja) {
		mensaje = new Mensaje();
		mensaje.setcompra(compra);
		verificarCantidad(compra);
		verificarPresupuestoElegido(compra);
		verificarSeleccionProveedor(compra);
		bandeja.agregarMensaje(mensaje);
	}

	
	public static void main(String[] args) {
		BandejaDeMensajes bandeja = new BandejaDeMensajes();
		
		Presupuesto presupuesto1 = new Presupuesto();
		presupuesto1.setMonto(100);
		Presupuesto presupuesto2 = new Presupuesto();
		presupuesto2.setMonto(200);
		Presupuesto presupuesto3 = new Presupuesto();
		presupuesto3.setMonto(300);
		
		Presupuesto presupuesto4 = new Presupuesto();
		presupuesto4.setMonto(800);
		
		Presupuesto presupuesto5 = new Presupuesto();
		presupuesto5.setMonto(1000);
		
		
		ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
		presupuestos.add(presupuesto1);
		presupuestos.add(presupuesto2);
		presupuestos.add(presupuesto3);
		presupuestos.add(presupuesto4);
		
		Compra compra = new Compra();
		compra.setRequierePresupuestos(true);
		compra.setPresupuestoElegido(presupuesto5);
		compra.setPresupuestos(presupuestos);

		
		validar(compra,bandeja);
		
		bandeja.mostrarMensajeAuxiliar(0);
		
	}
	
}

