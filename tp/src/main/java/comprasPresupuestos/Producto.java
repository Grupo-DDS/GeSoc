package comprasPresupuestos;

import java.util.ArrayList;

import criteriosCategorias.Categoria;
import criteriosCategorias.CriterioCategorizacion;

public class Producto {
	private String descripcion;
	private float valor = 0;
	public ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public Producto(String descripcion, float valor) {
		super();
		this.descripcion = descripcion;
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valorIngresado) {
		this.valor = valorIngresado;
	}
	private boolean buscarCriterio(CriterioCategorizacion criterio) {
		boolean encontrado = false;
			for(int i=0; i<categorias.size();i++) {
				Categoria cat = categorias.get(i);
				if(criterio == cat.getCriterio()) {
					encontrado = true;
					break;
				}
			}
	return encontrado;
	}
	
	public void agregarCategoria(Categoria categoria) {
		//Puede estar asociado a sólo una categoría de cada criterio
		if(categorias.isEmpty() || !this.buscarCriterio(categoria.getCriterio()))
		categorias.add(categoria);
	}
}
