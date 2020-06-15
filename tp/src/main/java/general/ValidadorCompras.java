package general;

public class ValidadorCompras {
	static Mensaje mensaje;
	
	public static boolean verificarCantidad(Compra compra){
		if(!compra.isRequierePresupuestos())
			return true;
		else
			return  compra.getPresupuestos().size() >= compra.getCantidadMinimaPresupuestos() ;	
	}
	
	public static boolean verificarPresupuestoElegido(Compra compra){
		return compra.getPresupuestos().stream()
				.anyMatch(presupuesto->presupuesto.getDetalles().stream()
						.allMatch(detallePresupuesto->detallePresupuesto.coincidePrecio()));
	}
	
	public static boolean verificarCriterio(Compra compra){
		Presupuesto presCriterio = compra.getCriterio().obtenerPresupuesto(compra);
		return presCriterio.equals(compra.getPresupuestoElegido());
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

