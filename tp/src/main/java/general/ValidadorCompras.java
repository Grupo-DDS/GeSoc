package general;

public class ValidadorCompras {
	static Mensaje mensaje;
	static int presupuestosRequeridos = 3;
	
	public static boolean verificarCantidad(Compra compra){
		if(!compra.isRequierePresupuestos())
			return true;
		else
			return presupuestosRequeridos == compra.cantidadDePresupuestos();	
	}
	
	public static boolean verificarPresupuestoElegido(Compra compra){
		return compra.getPresupuestos().stream()
				.anyMatch(presupuesto->presupuesto.getDetalles().stream()
						.allMatch(detallePresupuesto->detallePresupuesto.coincidePrecio()));
	}
	
	public static boolean verificarCriterio(Compra compra){
		return compra.getCriterio().verificar(compra);
	}
		
	public static void validar(Compra compra) {
		mensaje = new Mensaje();
		mensaje.setcompra(compra);
		mensaje.setcantidadPresupuestosIndicada(verificarCantidad(compra));
		mensaje.setpresupuestoElegido(verificarPresupuestoElegido(compra));
		mensaje.setCriterioCorrecto(verificarCriterio(compra));
		NotificarRevisores nr = new NotificarRevisores();
		nr.notificar(compra.getRevisores(),mensaje);
	}
	
}

