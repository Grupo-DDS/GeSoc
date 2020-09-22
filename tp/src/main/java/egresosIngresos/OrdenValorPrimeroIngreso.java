package egresosIngresos;

import java.util.List;

public class OrdenValorPrimeroIngreso extends Requerimiento {

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
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
	
*/
}
