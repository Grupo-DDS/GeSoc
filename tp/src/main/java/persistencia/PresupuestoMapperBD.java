package persistencia;

import comprasPresupuestos.Presupuesto;

public class PresupuestoMapperBD extends MapperBD<Presupuesto> {
	private static final PresupuestoMapperBD instance = new PresupuestoMapperBD();
	
	private PresupuestoMapperBD () {}
	public static PresupuestoMapperBD getInstance() {
		return instance;
	}
}
