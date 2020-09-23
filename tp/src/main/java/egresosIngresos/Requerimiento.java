package egresosIngresos;

import java.util.List;

public abstract class Requerimiento {
	private IngresosEgresos restante;
	
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,
			ReglaVinculacion regla){
				IngresosEgresos ingresosEgresosOrdenados = ordenar(egresosAVincular, ingresosAVincular);
				for (OperacionIngreso ingresoAVincular: ingresosEgresosOrdenados.getIngresosRestantes()) {
					for (OperacionEgreso egresoAVincular: ingresosEgresosOrdenados.getEgresosRestantes()) {
						if (regla.esVinculable(ingresoAVincular, egresoAVincular)){
							ingresoAVincular.getEgresos().add(egresoAVincular);
							egresoAVincular.setIngreso(ingresoAVincular);
						} else {
							restante.getEgresosRestantes().add(egresoAVincular);
							restante.getIngresosRestantes().add(ingresoAVincular);
						}
					}
				}
				
				return restante;
		}
public abstract IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular);
}
