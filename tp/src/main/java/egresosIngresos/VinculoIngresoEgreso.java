package egresosIngresos;

import java.util.ArrayList;

public class VinculoIngresoEgreso {
	private OperacionIngreso ingreso;
	private ArrayList<OperacionEgreso> egresos=new ArrayList<OperacionEgreso>();
	//private PeriodoAceptabilidadEgreso periodoAceptabilidad;
	
	public OperacionIngreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(OperacionIngreso ingreso) {
		this.ingreso = ingreso;
	}
	public void agregarEgreso(OperacionEgreso egreso) {
		//if((egreso.getFechaOperacion().compareTo(periodoAceptabilidad.getFechaInicioPeriodo()))>0 && (egreso.getFechaOperacion().compareTo(periodoAceptabilidad.getFechaFinPeriodo()))<0) {
		egresos.add(egreso);
		//}
	}
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

