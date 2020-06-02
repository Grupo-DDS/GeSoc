package com.validadorEgresos;

import java.util.ArrayList;

public class Presupuesto {
	//1 presupuesto con su lista de egresos de 1 proovedor
	ArrayList<OperacionEgreso> egresos = new ArrayList<OperacionEgreso>();
	ArrayList<DocumentoComercial> documentosComerciales = new ArrayList<DocumentoComercial>();
	int valorTotal = 0;
	
	public void agregarEgresos(OperacionEgreso egreso) {
		if(egresos.isEmpty() || egreso.getProveedor().equals(egresos.get(0).getProveedor()))
			egresos.add(egreso);
		
		
	}
	
	public void setValorTotal() { // Aca tengo el valor del presupuesto a partir de mis egresos
		for(int i = 0; i < egresos.size(); i++) {
			valorTotal += egresos.get(i).getValorDeEgreso();
		}    
	}
	
	public int getValorTotal() {
		return valorTotal;
	}
	
	public static void metodo() {
		
	}
	
	//asdasdsad
	
	
}
