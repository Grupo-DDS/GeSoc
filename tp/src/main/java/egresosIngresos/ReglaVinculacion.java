package egresosIngresos;

public abstract class ReglaVinculacion {

	protected abstract boolean esVinculable(OperacionIngreso ingresoAVincular, OperacionEgreso egresoAVincular);

}
