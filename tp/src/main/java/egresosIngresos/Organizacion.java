package egresosIngresos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import entidades.Entidad;

@Entity
public class Organizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	List<Entidad> entidades = new ArrayList<Entidad>();
	@OneToMany
	List<OperacionIngreso> ingresos = new ArrayList<OperacionIngreso>();
	@OneToMany (mappedBy = "organizacion")
	List<OperacionEgreso> egresos = new ArrayList<OperacionEgreso>();
	private Requerimiento requerimiento;
	private ReglaVinculacion regla;
	
	
	public List<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}

	public List<OperacionIngreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<OperacionIngreso> ingresos) {
		this.ingresos = ingresos;
	}

	public List<OperacionEgreso> getEgresos() {
		return egresos;
	}

	public void setEgresos(List<OperacionEgreso> egresos) {
		this.egresos = egresos;
	}

	public ReglaVinculacion getRegla() {
		return regla;
	}

	public void setRegla(ReglaVinculacion regla) {
		this.regla = regla;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Organizacion() {
		// TODO Auto-generated constructor stub
	}

	public Object getRequerimiento() {
		// TODO Auto-generated method stub
		return null;
	}
}
