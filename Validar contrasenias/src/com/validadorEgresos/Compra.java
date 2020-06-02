package com.validadorEgresos; 
import java.util.ArrayList;

public class Compra {
	 static ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();

	 static Presupuesto presupuestoElegido;
	 public static boolean requierePresupuestos;
	 
	 public int cantidadDePresupuestos() {
		 return presupuestos.size(); 
	 }

	public  ArrayList<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	public  void setPresupuestos(ArrayList<Presupuesto> _presupuestos) {
		presupuestos = _presupuestos;
	}
	
	public void agregarPresupuesto(Presupuesto presupuesto) {
		presupuestos.add(presupuesto);
	}

	public Presupuesto getPresupuestoElegido() {
		return presupuestoElegido;
	}

	public void setPresupuestoElegido(Presupuesto _presupuestoElegido) {
		presupuestoElegido = _presupuestoElegido;
	}

	public  boolean isRequierePresupuestos() {
		return requierePresupuestos;
	}
	
	public  void setRequierePresupuestos(boolean _requierePresupuestos) {
		requierePresupuestos = _requierePresupuestos;
	}
}
