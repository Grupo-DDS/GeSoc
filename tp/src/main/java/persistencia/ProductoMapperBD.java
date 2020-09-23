package persistencia;

import comprasPresupuestos.Producto;

public class ProductoMapperBD extends MapperBD<Producto>{
	private static final ProductoMapperBD instance = new ProductoMapperBD();
	
	private ProductoMapperBD () {}
	public static ProductoMapperBD getInstance() {
		return instance;
	}
}
