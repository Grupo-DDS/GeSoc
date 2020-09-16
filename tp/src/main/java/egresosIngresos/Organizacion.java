package egresosIngresos;

import java.util.ArrayList;
import java.util.List;

import entidades.Entidad;

public class Organizacion {
	ArrayList<Entidad> entidades = new ArrayList<Entidad>();
	List<OperacionIngreso> ingresos = new ArrayList<OperacionIngreso>();
	List<OperacionEgreso> egresos = new ArrayList<OperacionEgreso>();
	
	public Organizacion(ArrayList<Entidad> entidades, List<OperacionIngreso> ingresos2,
			List<OperacionEgreso> egresos) {
		super();
		this.entidades = entidades;
		this.ingresos = ingresos2;
		this.egresos = egresos;
	}
}
