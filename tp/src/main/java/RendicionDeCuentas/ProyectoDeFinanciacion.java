package RendicionDeCuentas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import comprasPresupuestos.Presupuesto;
import egresosIngresos.OperacionIngreso;
import validadorDeCompras.Usuario;

@Entity
public class ProyectoDeFinanciacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario directorResponsable;
	private Float montoTotalAsignado;
	private int cantPresupuestosMinima;
	@OneToMany
	private List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	@OneToMany
	private List<OperacionIngreso> ingresos = new ArrayList<OperacionIngreso>();
	

	
	
	public ProyectoDeFinanciacion(Long id, Usuario directorResponsable, Float montoTotalAsignado, int cantPresupuestosMinima,
			List<Presupuesto> presupuestos, List<OperacionIngreso> ingresos) {
		super();
		this.id = id;
		this.directorResponsable = directorResponsable;
		this.montoTotalAsignado = montoTotalAsignado;
		this.cantPresupuestosMinima = cantPresupuestosMinima;
		this.presupuestos = presupuestos;
		this.ingresos = ingresos;
	}
	public ProyectoDeFinanciacion() {
		super();
	}
	public Usuario getDirectorResponsable() {
		return directorResponsable;
	}
	public void setDirectorResponsable(Usuario directorResponsable) {
		this.directorResponsable = directorResponsable;
	}
	public Float getMontoTotalAsignado() {
		return montoTotalAsignado;
	}
	public void setMontoTotalAsignado(Float montoTotalAsignado) {
		this.montoTotalAsignado = montoTotalAsignado;
	}
	public int getCantPresupuestosMinima() {
		return cantPresupuestosMinima;
	}
	public void setCantPresupuestosMinima(int cantPresupuestos) {
		this.cantPresupuestosMinima = cantPresupuestos;
	}
	public List<Presupuesto> getPresupuestos() {
		return presupuestos;
	}
	public void setPresupuestos(List<Presupuesto> presupuestos) {
		this.presupuestos = presupuestos;
	}
	public List<OperacionIngreso> getIngresos() {
		return ingresos;
	}
	public void setIngresos(List<OperacionIngreso> ingresos) {
		this.ingresos = ingresos;
	}

}
