package egresosIngresos;

import java.util.List;


public class OrdenFecha extends Requerimiento {

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	  private ArrayList<ArrayList<OperacionEgreso>> egresosAceptados=new ArrayList<ArrayList<OperacionEgreso>>();
	 
	
	public void ordenarEgresosPorFecha() {
		Collections.sort(organizacion.egresos, new Comparator<OperacionEgreso>(){
			@Override
			public int compare(OperacionEgreso unEgreso,OperacionEgreso otroEgreso) {
				return unEgreso.getFechaOperacion().compareTo(otroEgreso.getFechaOperacion());
			}
			
		});
			
	}
	
	public void ordenar() {
		int i=0;
	    ArrayList<OperacionEgreso> egresosOrganizacion=new ArrayList<OperacionEgreso>();
	    this.ordenarEgresosPorFecha();
	    for(OperacionEgreso unEgreso:organizacion.egresos){
	        egresosOrganizacion.add(unEgreso);
	        }
		for(OperacionIngreso unIngreso:organizacion.ingresos) {
	    	float valorIngreso= unIngreso.getMontoTotal();
	    	for(OperacionEgreso unEgreso:egresosOrganizacion) {
	    		if((unEgreso.getFechaOperacion().compareTo(unIngreso.getPeriodoAceptabilidad().getFechaInicioPeriodo()))>0 && (unEgreso.getFechaOperacion().compareTo(unIngreso.getPeriodoAceptabilidad().getFechaFinPeriodo()))<0 && valorIngreso>unEgreso.getValorDeEgreso()) {
	    	    valorIngreso-=unEgreso.getValorDeEgreso();
	    	    egresosAceptados.get(i).add(unEgreso);
	    	    egresosOrganizacion.remove(unEgreso);
	    		}
	        }
	    	i+=1;
	    }
	}
 */
}
