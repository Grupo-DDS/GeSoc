package egresosIngresos;



public class VinculoIngresoEgreso {
	public Organizacion organizacion=new Organizacion(null, null, null);
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	/*public void aceptarEgresos() {
	    int i=0;
	    ArrayList<OperacionEgreso> egresosOrganizacion=new ArrayList<OperacionEgreso>();
	    this.ordenarEgresosPorValor();
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
	

	public void ingresosCompatibles() {
		int i=0;
		for(OperacionEgreso unEgreso:organizacion.egresos) {
			for(OperacionIngreso unIngreso:organizacion.ingresos) {
				if((unEgreso.getFechaOperacion().compareTo(unIngreso.getPeriodoAceptabilidad().getFechaInicioPeriodo()))>0 && (unEgreso.getFechaOperacion().compareTo(unIngreso.getPeriodoAceptabilidad().getFechaFinPeriodo()))<0 && unIngreso.getMontoTotal()>unEgreso.getValorDeEgreso()) {
					ingresosCompatibles.get(i).add(unIngreso);
				}
			}
			i+=1;
		}
	}
	*/
	/*private float sumatoriaEgresos() {
		float sum=0;
		for (OperacionEgreso unEgreso:egresos) {
			sum+=unEgreso.getValorDeEgreso();
		}
		return sum;
	}
	public  boolean justificarIngreso() {
		return ingreso.getMontoTotal() >= this.sumatoriaEgresos();
	}
	*/
}
