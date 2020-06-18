package general;

import java.util.ArrayList;

public class ValidadorCompras {
	static Mensaje mensaje;
	ArrayList <Compra> listaCompra = new ArrayList<Compra>(); // Deberian cargarse las comrpas en esta lista, y el validador deberia ir tomando cada compra como un FIFO.
	
	public ValidadorCompras(ArrayList<Compra> listaCompra) {
		super();
		this.listaCompra = listaCompra;
	}

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

