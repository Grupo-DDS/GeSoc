package egresosIngresos;

import java.util.List;

public abstract class Requerimiento {
	IngresosEgresos restante;
	
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,
			ReglaVinculacion regla){
				IngresosEgresos ingresosEgresosOrdenados = ordenar(egresosAVincular, ingresosAVincular);
				for (OperacionIngreso ingresoAVincular: ingresosAVincular) {
					for (OperacionEgreso egresoAVincular: egresosAVincular) {
						if (regla.esVinculable(ingresoAVincular, egresoAVincular)){
							ingresoAVincular.getEgresos().add(egresoAVincular);
							egresoAVincular.setIngreso(ingresoAVincular);
						} else {
							restante.egresosRestantes.add(egresoAVincular);
							restante.ingresosRestantes.add(ingresoAVincular);
						}
					}
				}
				
				return restante;
		}
public abstract IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular);
}
