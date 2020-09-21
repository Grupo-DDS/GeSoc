package validadorDeCompras;

import comprasPresupuestos.Compra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
//@Table(name = "USUARIO")

public class Mensaje{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static boolean isCantidadPresupuestosIndicada() {
		return cantidadPresupuestosIndicada;
	}

	public static void setCantidadPresupuestosIndicada(boolean cantidadPresupuestosIndicada) {
		Mensaje.cantidadPresupuestosIndicada = cantidadPresupuestosIndicada;
	}

	public static boolean isPresupuestoElegido() {
		return presupuestoElegido;
	}

	public static void setPresupuestoElegido(boolean presupuestoElegido) {
		Mensaje.presupuestoElegido = presupuestoElegido;
	}

	public static Compra getCompra() {
		return compra;
	}

	public static void setCompra(Compra compra) {
		Mensaje.compra = compra;
	}

	public static boolean cantidadPresupuestosIndicada;
	public static boolean presupuestoElegido;
	public static boolean criterioCorrecto;
	public static Compra compra;
	
	public boolean iscantidadPresupuestosIndicada() {
		return cantidadPresupuestosIndicada;
	}

	public   void setcantidadPresupuestosIndicada(boolean _cantidadPresupuestosIndicada) {
		cantidadPresupuestosIndicada = _cantidadPresupuestosIndicada;
	}
	public  boolean ispresupuestoElegido() {
		return presupuestoElegido;
	}

	public  void setpresupuestoElegido(boolean _presupuestoElegido) {
		presupuestoElegido = _presupuestoElegido;
	}

	public  Compra iscompra() {
		return compra;
	}

	public   void setcompra(Compra _compra) {
		compra = _compra;
	}

	public static boolean isCriterioCorrecto() {
		return criterioCorrecto;
	}

	public void setCriterioCorrecto(boolean criterioCorrecto) {
		Mensaje.criterioCorrecto = criterioCorrecto;
	}
	
}
