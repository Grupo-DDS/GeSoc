package egresosIngresos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenValorPrimeroIngreso extends Requerimiento {
	private ArrayList<ArrayList<OperacionIngreso>> ingresosCompatibles=new ArrayList<ArrayList<OperacionIngreso>>();
	public void ordenarIngresosPorValor() {
		Collections.sort(organizacion.ingresos, new Comparator<OperacionIngreso>(){
			public int compare(OperacionIngreso unIngreso,OperacionIngreso otroIngreso) {
				return new Float(unIngreso.getMontoTotal()).compareTo(new Float(otroIngreso.getMontoTotal()));
			}
			
		});
			
	}
	@Override
	public void ordenar() {
		int i=0;
		ArrayList<OperacionIngreso> ingresosOrganizacion=new ArrayList<OperacionIngreso>();
	    this.ordenarIngresosPorValor();
	    for(OperacionIngreso unIngreso:organizacion.ingresos){
	        ingresosOrganizacion.add(unIngreso);
	        }
		for(OperacionEgreso unEgreso:organizacion.egresos) {
			for(OperacionIngreso unIngreso:ingresosOrganizacion) {
				if(unEgreso.compararFechas(unIngreso)) {
					ingresosCompatibles.get(i).add(unIngreso);
				}
			}
			i+=1;
		}
	}
	

}
