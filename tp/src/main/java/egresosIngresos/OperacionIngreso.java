package egresosIngresos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="INGRESOS")
public class OperacionIngreso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INGRESO")
	private Long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="MONTO_TOTAL")
	private float montoTotal;
	
	@Column(name="FECHA_OPERACION")
	private Date fechaOperacion;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="ID_PERIODO_ACEPTABILIDAD_EGRESO")
//	private PeriodoAceptabilidadEgreso periodoAceptabilidad;
	
	@OneToMany(mappedBy="ingreso")
	private List<OperacionEgreso> egresos=new ArrayList<OperacionEgreso>();
	
	
	
	@Override
	public String toString() {
		return "OperacionIngreso [id=" + id + ", descripcion=" + descripcion + ", montoTotal=" + montoTotal
				 + ", egresos=" + egresos + ", fechaOperacion=" + fechaOperacion + "]";
	}
	
	
	public OperacionIngreso(String descripcion, float montoTotal,
			PeriodoAceptabilidadEgreso periodoAceptabilidad, ArrayList<OperacionEgreso> egresos, Date fechaOperacion) {
		super();
		
		this.descripcion = descripcion;
		this.montoTotal = montoTotal;
		//this.periodoAceptabilidad = periodoAceptabilidad;
		this.egresos = egresos;
		this.fechaOperacion=fechaOperacion;
	}

	public OperacionIngreso() {}
	public long getId() {
		return id;
	}
	
	public Date getFechaOperacion() {
		return fechaOperacion;
	}


	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<OperacionEgreso> getEgresos() {
		return egresos;
	}
	public void setEgresos(ArrayList<OperacionEgreso> egresos) {
		this.egresos = egresos;
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
//	public PeriodoAceptabilidadEgreso getPeriodoAceptabilidad() {
//		return periodoAceptabilidad;
//	}
//	public void setPeriodoAceptabilidad(PeriodoAceptabilidadEgreso periodoAceptabilidad) {
//		this.periodoAceptabilidad = periodoAceptabilidad;
//	}
}

