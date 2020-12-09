package egresosIngresos;

import javax.persistence.Entity;


@Entity
public class ReglaFecha extends ReglaVinculacion {
	private static final ReglaFecha instance = new ReglaFecha();

	private ReglaFecha() {
	}

	public static ReglaFecha getInstance() {
		return instance;
	}
	public boolean esVinculable(OperacionIngreso ingresoAVincular, OperacionEgreso egresoAVincular) {
		return(egresoAVincular.getFechaOperacion().compareTo(ingresoAVincular.getFechaInicio())>0 && egresoAVincular.
				getFechaOperacion().compareTo(ingresoAVincular.getFechaFin())<0 &&ingresoAVincular.
					getMontoTotal()>=egresoAVincular.getValorDeEgreso());
	}
}
