package general;

public class Mensaje{
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
