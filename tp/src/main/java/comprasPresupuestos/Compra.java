package comprasPresupuestos; 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import validadorDeCompras.Usuario;

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToMany //TODO PREGUNTAR
	private List<Producto> productos = new ArrayList<Producto>();
	
	@OneToMany
	private ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	
	@OneToOne
	private Presupuesto presupuestoElegido;
	private int cantidadMinimaPresupuestos;
	
	@ManyToMany
	private ArrayList<Usuario> revisores = new ArrayList<Usuario>();
	
	//TODO PREGUNTAR
	private CriterioSeleccionPresupuesto criterio;
	
	public Compra(List<Producto> listaProducto, ArrayList<Presupuesto> presupuestos, Presupuesto presupuestoElegido,
			int cantidadMinimaPresupuestos, ArrayList<Usuario> revisores, CriterioSeleccionPresupuesto criterio) {
		super();
		this.productos = listaProducto;
		this.presupuestos = presupuestos;
		this.presupuestoElegido = presupuestoElegido;
		this.cantidadMinimaPresupuestos = cantidadMinimaPresupuestos;
		this.revisores = revisores;
		this.criterio = criterio;
	}



	public float getValorTotal() {
		float total = 0;
		for(Producto unProducto : this.getProductos())
			total += unProducto.getValor();
		return total;
	}

	public  ArrayList<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	public  void setPresupuestos(ArrayList<Presupuesto> _presupuestos) {
		presupuestos = _presupuestos;
	}

	public void agregarPresupuesto(Presupuesto presupuesto) {
		presupuestos.add(presupuesto);
	}

	public Presupuesto getPresupuestoElegido() {
		return presupuestoElegido;
	}

	public void setPresupuestoElegido(Presupuesto _presupuestoElegido) {
		presupuestoElegido = _presupuestoElegido;
	}

	public boolean isRequierePresupuestos() {
		return cantidadMinimaPresupuestos > 0;
	}

	public ArrayList<Usuario> getRevisores() {
		return revisores;
	}

	public void setRevisores(ArrayList<Usuario> revisores) {
		this.revisores = revisores;
	}

	public CriterioSeleccionPresupuesto getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioSeleccionPresupuesto criterio) {
		this.criterio = criterio;
	}

	public void agregarRevisor(Usuario usuario) {
		revisores.add(usuario);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}



	public int getCantidadMinimaPresupuestos() {
		return cantidadMinimaPresupuestos;
	}



	public void setCantidadMinimaPresupuestos(int cantidadMinimaPresupuestos) {
		this.cantidadMinimaPresupuestos = cantidadMinimaPresupuestos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
