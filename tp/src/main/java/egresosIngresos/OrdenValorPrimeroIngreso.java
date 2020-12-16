package egresosIngresos;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class OrdenValorPrimeroIngreso extends Requerimiento {
	private static final OrdenValorPrimeroIngreso instance = new OrdenValorPrimeroIngreso();

	private OrdenValorPrimeroIngreso() {
	}

	public static OrdenValorPrimeroIngreso getInstance() {
		return instance;
	}

	@Override
	public IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular) {
		egresosAVincular.sort(Comparator.comparing(OperacionEgreso::getValorDeEgreso));
		ingresosAVincular.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
		return new IngresosEgresos(egresosAVincular, ingresosAVincular);
	}

	@Override
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,
			ReglaVinculacion regla) {
		ingresosAVincular.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
		int index = 0;
		int sizeEgresos = egresosAVincular.size();
		while (index < sizeEgresos) {			
			OperacionEgreso unEgreso = egresosAVincular.get(index);
			for (OperacionIngreso unIngreso : ingresosAVincular) {
				if (regla.esVinculable(unIngreso, unEgreso))
					unIngreso.getEgresos().add(unEgreso);
			}
			index++;
		}
		return null;
	}

}
