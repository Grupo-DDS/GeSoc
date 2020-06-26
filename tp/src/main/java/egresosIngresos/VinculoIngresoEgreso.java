package general;

public class VinculoIngresoEgreso {
	private OperacionIngreso ingreso;
	private OperacionEgreso egreso;
	 
	public OperacionIngreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(OperacionIngreso ingreso) {
		this.ingreso = ingreso;
	}
	public OperacionEgreso getEgreso() {
		return egreso;
	}
	public void setEgreso(OperacionEgreso egreso) {
		this.egreso = egreso;
	}
}
