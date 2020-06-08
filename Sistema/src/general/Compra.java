package general; 
import java.util.ArrayList;

public class Compra {
	 static ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	 static Presupuesto presupuestoElegido;
	 public static boolean requierePresupuestos; 
	 ArrayList<Usuario> revisores = new ArrayList<Usuario>();
	 private Criterio criterio;
	 
	 public int cantidadDePresupuestos() {
		 return presupuestos.size(); 
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

	public  boolean isRequierePresupuestos() {
		return requierePresupuestos;
	}
	
	public  void setRequierePresupuestos(boolean _requierePresupuestos) {
		requierePresupuestos = _requierePresupuestos;
	}

	public ArrayList<Usuario> getRevisores() {
		return revisores;
	}

	public void setRevisores(ArrayList<Usuario> revisores) {
		this.revisores = revisores;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}
	
	public void agregarRevisor(Usuario usuario) {
		revisores.add(usuario);
	}
}
