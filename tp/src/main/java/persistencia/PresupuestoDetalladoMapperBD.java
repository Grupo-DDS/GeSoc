package persistencia;

import comprasPresupuestos.PresupuestoDetallado;

public class PresupuestoDetalladoMapperBD extends MapperBD<PresupuestoDetallado>{
	private static final PresupuestoDetalladoMapperBD instance = new PresupuestoDetalladoMapperBD();
	
	private PresupuestoDetalladoMapperBD () {}
	public static PresupuestoDetalladoMapperBD getInstance() {
		return instance;
	}
}
