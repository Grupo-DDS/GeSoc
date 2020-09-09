package egresosIngresos;

import java.util.List;

public class VinculoIngresoEgreso {
	
	private Organizacion organizacion = new Organizacion();
	private OperacionIngreso ingreso = new OperacionIngreso();
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	
	private List<OperacionEgreso> egresosAceptados = (List<OperacionEgreso>) organizacion.egresos.stream().filter(egreso -> (egreso.compararFechas(ingreso)));

	
	/*
	 * if((egreso.getFechaOperacion().compareTo(ingreso.getPeriodoAceptabilidad().getFechaInicioPeriodo()))>0 && (egreso.getFechaOperacion().compareTo(ingreso.getPeriodoAceptabilidad().getFechaFinPeriodo()))<0) {
	private float sumatoriaEgresos() {
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

