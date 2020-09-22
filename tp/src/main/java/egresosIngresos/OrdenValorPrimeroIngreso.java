package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimeroIngreso extends Requerimiento {

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular){
		// TODO Auto-generated method stub
		return null;
	}
	
	public void ordenar(List<OperacionIngreso> ingresoAVincular) {
		ingresoAVincular.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
	}
	
}
