package com.validadorEgresos;

public class Mensaje{
	public static boolean cantidadPresupuestosIndicada;
	public static boolean presupuestoElegido;
	public static boolean seleccionProveedor;
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
	public  boolean isseleccionProveedor() {
		return seleccionProveedor;
	}

	public  void setseleccionProveedor(boolean _seleccionProveedor) {
		seleccionProveedor = _seleccionProveedor;
	}
	public  Compra iscompra() {
		return compra;
	}

	public   void setcompra(Compra _compra) {
		compra = _compra;
	}
	
}
