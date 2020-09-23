package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimeroEgreso extends Requerimiento {
	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular){
		egresosAVincular.sort(Comparator.comparing(OperacionEgreso::getValorDeEgreso));
		ingresosAVincular.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
		return new IngresosEgresos(egresosAVincular, ingresosAVincular);
		}
}
