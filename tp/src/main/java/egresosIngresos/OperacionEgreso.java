package egresosIngresos;

import java.util.Date;

import comprasPresupuestos.Compra;

public class OperacionEgreso {
	private DocumentoComercial comprobante;
	private Date fechaOperacion;
	private MedioDePago medioDePago;
	private Organizacion organizacion;
	private Compra compra;
	private Proveedor proveedor;

	public OperacionEgreso(DocumentoComercial comprobante, Date fechaOperacion, MedioDePago medioDePago,
			Organizacion organizacion, Compra compra, Proveedor proveedor) {
		super();
		this.comprobante = comprobante;
		this.fechaOperacion = fechaOperacion;
		this.medioDePago = medioDePago;
		this.organizacion = organizacion;
		this.compra = compra;
		this.proveedor = proveedor;
	}
	public DocumentoComercial getComprobante() {
		return comprobante;
	}
	public void setComprobante(DocumentoComercial comprobante) {
		this.comprobante = comprobante;
	}
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
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
		return compra.isRequierePresupuestos() ?
				compra.getPresupuestoElegido().getValorTotal() : compra.getValorTotal();
	}

}
