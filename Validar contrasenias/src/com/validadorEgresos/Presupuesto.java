package com.validadorEgresos;

public class Presupuesto {
	DocumentoComercial[] documentosComerciales;
	float monto;
	Producto[] productos;
	public DocumentoComercial[] getDocumentosComerciales() {
		return documentosComerciales;
	}
	public void setDocumentosComerciales(DocumentoComercial[] documentosComerciales) {
		this.documentosComerciales = documentosComerciales;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Producto[] getProductos() {
		return productos;
	}
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}
}
