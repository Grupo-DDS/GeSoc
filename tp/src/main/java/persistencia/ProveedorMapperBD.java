package persistencia;

import egresosIngresos.Proveedor;

public class ProveedorMapperBD extends MapperBD<Proveedor>{
	private static final ProveedorMapperBD instance = new ProveedorMapperBD();
	
	private ProveedorMapperBD () {}
	public static ProveedorMapperBD getInstance() {
		return instance;
	}
}
