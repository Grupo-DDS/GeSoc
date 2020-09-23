package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenFecha extends Requerimiento {
	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular){
		egresosAVincular.sort(Comparator.comparing(OperacionEgreso::getFechaOperacion));
		ingresosAVincular.sort(Comparator.comparing(OperacionIngreso::getFechaOperacion));
		return new IngresosEgresos(egresosAVincular, ingresosAVincular);
		}
}
