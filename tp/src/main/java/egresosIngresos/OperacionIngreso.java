package egresosIngresos;

//import java.util.Date;

public class OperacionIngreso {
	private String descripcion;
	private float montoTotal;
	//private Date fechaOperacion;
	private PeriodoAceptabilidadEgreso periodoAceptabilidad;
	
	public OperacionIngreso(String descripcion, float montoTotal, PeriodoAceptabilidadEgreso periodoAceptabilidad) {
		super();
		this.descripcion = descripcion;
		this.montoTotal = montoTotal;
		this.periodoAceptabilidad = periodoAceptabilidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	/*public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}*/
	public PeriodoAceptabilidadEgreso getPeriodoAceptabilidad() {
		return periodoAceptabilidad;
	}
	public void setPeriodoAceptabilidad(PeriodoAceptabilidadEgreso periodoAceptabilidad) {
		this.periodoAceptabilidad = periodoAceptabilidad;
	}
}

