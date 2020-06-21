package general;

import java.util.LinkedList;
import java.util.Queue;

public class ValidadorCompras {
	static Queue<Compra> listaCompra = new LinkedList<Compra>(); // Deberian cargarse las comrpas en esta lista, y el validador deberia ir tomando cada compra como un FIFO.
	private static ValidadorCompras instance = new ValidadorCompras();
	public static ValidadorCompras getInstance() {
		return instance;
	}

	private ValidadorCompras(){

	}

	public void notificar(Compra compra) {
		this.listaCompra.add(compra);
	}

	public static boolean verificarCantidad(Compra compra){
		return !compra.isRequierePresupuestos()  || compra.getPresupuestos().size() >= compra.getCantidadMinimaPresupuestos();	
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

	public void validar(){
		while(listaCompra.size() > 0) {
			Compra compra = listaCompra.poll();
			System.out.println("pasaron cosas");
			Mensaje mensaje = new Mensaje();
			mensaje.setcompra(compra);
			mensaje.setcantidadPresupuestosIndicada(verificarCantidad(compra));
			mensaje.setpresupuestoElegido(verificarPresupuestoElegido(compra));
			mensaje.setCriterioCorrecto(verificarCriterio(compra));
			NotificarRevisores nr = new NotificarRevisores();
			nr.notificar(compra.getRevisores(),mensaje);			
		}
	}
}

