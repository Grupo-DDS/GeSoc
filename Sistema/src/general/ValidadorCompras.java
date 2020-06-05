package general;

public class ValidadorCompras {
	static Mensaje mensaje;
	static Criterio criterio = new Criterio();
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
		criterio.proveedorMin(compra,mensaje);
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
		ValidadorCompras val = new ValidadorCompras();
		Compra compra = new Compra();	
		Presupuesto p1 = new Presupuesto();
		Presupuesto p2 = new Presupuesto();
		Presupuesto p3 = new Presupuesto();
		p1.setValorTotal(1);
		p2.setValorTotal(10);
		p3.setValorTotal(1000);
		compra.agregarPresupuesto(p1);
		compra.agregarPresupuesto(p2);
		compra.agregarPresupuesto(p3);
		val.verificarSeleccionProveedor(compra);
	}
	
}

