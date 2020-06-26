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
		listaCompra.add(compra);
	}

	public static boolean verificarCantidad(Compra compra){
		return !compra.isRequierePresupuestos() || compra.getPresupuestos().size() >= compra.getCantidadMinimaPresupuestos();	
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
			Mensaje mensaje = new Mensaje();
			mensaje.setcompra(compra);
			mensaje.setcantidadPresupuestosIndicada(verificarCantidad(compra));
			System.out.printf("Verifica cantidad: ");
			System.out.printf(Boolean.toString(verificarCantidad(compra)));
			System.out.println();
			mensaje.setpresupuestoElegido(verificarPresupuestoElegido(compra));
			System.out.printf("Verifica presupuesto elegido: ");
			System.out.printf(Boolean.toString(verificarPresupuestoElegido(compra)));
			System.out.println();
			mensaje.setCriterioCorrecto(verificarCriterio(compra));
			System.out.printf("Verifica criterio: ");
			System.out.printf(Boolean.toString(verificarCriterio(compra)));
			System.out.println();
			NotificarRevisores nr = new NotificarRevisores();
			nr.notificar(compra.getRevisores(),mensaje);			
		}
	}
}

