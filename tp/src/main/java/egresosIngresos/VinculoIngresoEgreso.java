package egresosIngresos;

public class VinculoIngresoEgreso {
	private OperacionIngreso ingreso;
	private ArrayList<OperacionEgreso> egresos=new ArrayList<OperacionEgreso>();
	 
	public OperacionIngreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(OperacionIngreso ingreso) {
		this.ingreso = ingreso;
	}
	public void setEgreso(OperacionEgreso egreso) {
		egresos.add(egreso);
	}
}
