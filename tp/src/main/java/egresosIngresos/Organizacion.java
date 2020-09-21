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
	
	public Organizacion(ArrayList<Entidad> entidades, List<OperacionIngreso> ingresos2,
			List<OperacionEgreso> egresos) {
		super();
		this.entidades = entidades;
		this.ingresos = ingresos2;
		this.egresos = egresos;
	}

	public Organizacion() {
		// TODO Auto-generated constructor stub
	}
}
