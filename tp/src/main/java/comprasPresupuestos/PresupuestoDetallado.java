package comprasPresupuestos;

public class PresupuestoDetallado {
	public PresupuestoDetallado(float precio, Producto productoCompra) {
		super();
		this.precio = precio;
		this.productoCompra = productoCompra;
	}
	private float precio;
	private Producto productoCompra;
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Producto getProductoCompra() {
		return productoCompra;
	}
	public void setProductoCompra(Producto productoCompra) {
		this.productoCompra = productoCompra;
	}
	public boolean coincidePrecio() {
		return precio == productoCompra.getValor();
	}
}
