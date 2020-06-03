package general;

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
				if (presupuesto1.getValorTotal()>presupuesto2.getValorTotal())
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

	
	
}

