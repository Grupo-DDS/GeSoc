package general;

import java.util.ArrayList;

public class OperacionEgreso {
	DocumentoComercial comprobante;
	int fechaOperacion;
	MedioDePago medioDePago;
	Organizacion organizacion;
	ArrayList<Producto> productos = new ArrayList<Producto>();
	Proveedor proveedor;
	float valorDeEgreso;
	
	public DocumentoComercial getComprobante() {
		return comprobante;
	}
	public void setComprobante(DocumentoComercial comprobante) {
		this.comprobante = comprobante;
	}
	public int getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(int fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public MedioDePago getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public float getValorDeEgreso() {
		return valorDeEgreso;
	}
	public void setValorDeEgreso() {	
		for(int i = 0; i < productos.size(); i++)
			this.valorDeEgreso += productos.get(i).getValor();		
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
}
