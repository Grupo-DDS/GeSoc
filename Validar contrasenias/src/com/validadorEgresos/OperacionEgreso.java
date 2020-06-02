package com.validadorEgresos;

public class OperacionEgreso {
	DocumentoComercial comprobante;
	int fechaOperacion;
	MedioDePago medioDePago;
	Organizacion organizacion;
	Producto producto;
	Proveedor proveedor;
	float valorDeEgreso;
	//asdasd
	
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
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
	public void setValorDeEgreso(float valorDeEgreso) {
		this.valorDeEgreso = valorDeEgreso;
	}
}
