package validadorDeCompras;

import comprasPresupuestos.Compra;

public class DarAltaRevisorCompra {
	
	void darAlta(Usuario usuario,Compra compra) {
		compra.agregarRevisor(usuario);
	}
}
