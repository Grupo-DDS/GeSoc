package egresosIngresos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class OrdenMix extends Requerimiento {
	
	@OneToMany
	private List<Requerimiento> requerimientos;
	
	@Override
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular, ReglaVinculacion regla){
	IngresosEgresos restante = new IngresosEgresos(egresosAVincular, ingresosAVincular);
		for (Requerimiento requerimiento : requerimientos){
			restante = requerimiento.vincular(restante.getEgresosRestantes(), restante.getIngresosRestantes(),regla);
			if (restante.getEgresosRestantes().isEmpty() || restante.getIngresosRestantes().isEmpty()){
				break;
			}
		}
		return restante;
	}

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular) {
		// TODO Auto-generated method stub
		return null;
	}


}
