package egresosIngresos;

public class ReglaFecha extends ReglaVinculacion {

	public boolean esVinculable(OperacionIngreso ingresoAVincular, OperacionEgreso egresoAVincular) {
		if(egresoAVincular.getFechaOperacion().compareTo(ingresoAVincular.getFechaInicio())>0 && egresoAVincular.getFechaOperacion().compareTo(ingresoAVincular.getFechaFin())<0 &&ingresoAVincular.getMontoTotal()>=egresoAVincular.getValorDeEgreso()) {
			return true;
		}
		return false;
	}

}
