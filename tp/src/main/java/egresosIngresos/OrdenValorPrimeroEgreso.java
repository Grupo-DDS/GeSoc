package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimeroEgreso extends Requerimiento {
	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular){
		return new IngresosEgresos(egresosAVincular, ingresosAVincular);
		}

		

	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,ReglaVinculacion regla){
		egresosAVincular.sort(Comparator.comparing(OperacionEgreso::getValorDeEgreso));
		for(OperacionIngreso unIngreso:ingresosAVincular){
			for(OperacionEgreso unEgreso:egresosAVincular){
				if(regla.esVinculable(unIngreso, unEgreso))
					unIngreso.getEgresos().add(unEgreso);
			}
		}
		return null;
	}
}
