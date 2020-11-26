package egresosIngresos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import comprasPresupuestos.Compra;
@Entity
@Table(name="EGRESOS")
public class OperacionEgreso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EGRESO")
	private Long id;
	
	@Column(name="FECHA_EGRESO")
	private Date fechaOperacion;
	
	@OneToOne
	@JoinColumn(name="ID_DOC_COMERCIAL")
	private DocumentoComercial comprobante;

	@OneToOne
	@JoinColumn(name="ID_MEDIO_DE_PAGO")
	private MedioDePago medioDePago;
	
	@ManyToOne
	@JoinColumn(name="ID_ORGANIZACION")
	private Organizacion organizacion;
	
	@OneToOne
	@JoinColumn(name="ID_COMPRA")
	private Compra compra;
	
	@OneToOne
	@JoinColumn(name="ID_PROVEEDOR")
	private Proveedor proveedor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ingreso")
	private OperacionIngreso ingreso;
	
	public OperacionEgreso() {}

	public OperacionEgreso(Long id, DocumentoComercial comprobante, Date fechaOperacion, MedioDePago medioDePago,
			Organizacion organizacion, Compra compra, Proveedor proveedor, OperacionIngreso ingreso) {
		super();
		this.id = id;
		this.comprobante = comprobante;
		this.fechaOperacion = fechaOperacion;
		this.medioDePago = medioDePago;
		this.organizacion = organizacion;
		this.compra = compra;
		this.proveedor = proveedor;
		this.ingreso= ingreso;
	}
	


	@Override
	public String toString() {
		return "OperacionEgreso [id=" + id + ", fechaOperacion=" + fechaOperacion + ", comprobante=" + comprobante
				+ ", medioDePago=" + medioDePago + ", organizacion=" + organizacion + ", compra=" + compra
				+ ", proveedor=" + proveedor + ", ingreso=" + ingreso + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
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

	public OperacionIngreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(OperacionIngreso ingreso) {
		this.ingreso = ingreso;
	}

	public float getValorDeEgreso() {
		return compra.isRequierePresupuestos() ?
				compra.getPresupuestoElegido().getValorTotal() : compra.getValorTotal();
	}

}
