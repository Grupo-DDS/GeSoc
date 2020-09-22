package egresosIngresos;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimeroEgreso extends Requerimiento {

	public void ordenar(List<OperacionEgreso> egresosAVincular) {
		egresosAVincular.sort(Comparator.comparing(OperacionEgreso::getValorDeEgreso));
		
	}

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
