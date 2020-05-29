package com.validadorEgresos;

public class ValidadorCompras {
	static Mensaje mensaje;
	static int presupuestosRequeridos = 3;
	
	public static void validar(Compra compra,BandejaDeMensajes bandeja) {
		mensaje = new Mensaje();
		mensaje.setcompra(compra);
		verificarCantidad(compra);
		verificarPresupuestoElegido(compra);
		verificarSeleccionProveedor(compra);
		bandeja.agregarMensaje(mensaje);
	}
	public static void verificarCantidad(Compra compra){
		if(!compra.isRequierePresupuestos())
			mensaje.setcantidadPresupuestosIndicada(true);
		else
			mensaje.setcantidadPresupuestosIndicada(presupuestosRequeridos == Compra.cantidadDePresupuestos());
		
	}
	public static void verificarPresupuestoElegido(Compra compra){
		boolean set = compra.getPresupuestos().contains(compra.getPresupuestoElegido());
		mensaje.setpresupuestoElegido(set);
	}
	public static void verificarSeleccionProveedor(Compra compra){
		compra. ()
	}
}
