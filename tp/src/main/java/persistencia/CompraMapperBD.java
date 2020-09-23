package persistencia;

import comprasPresupuestos.Compra;


public class CompraMapperBD extends MapperBD<Compra>{

	private static final CompraMapperBD instance = new CompraMapperBD();
	
	private CompraMapperBD () {}
	public static CompraMapperBD getInstance() {
		return instance;
	}
	
}