package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimeroIngreso extends Requerimiento {

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular){
		return new IngresosEgresos(egresosAVincular, ingresosAVincular);
	}
	
	
	
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,ReglaVinculacion regla){
		ingresosAVincular.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
		OperacionEgreso unEgreso = egresosAVincular.get(0);
		for(OperacionIngreso unIngreso:ingresosAVincular){
			if(regla.esVinculable(unIngreso, unEgreso))
				unIngreso.getEgresos().add(unEgreso);
		}
		return null;
	}
	
}
