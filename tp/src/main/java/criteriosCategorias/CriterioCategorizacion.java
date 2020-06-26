package criteriosCategorias;

import java.util.ArrayList;

public class CriterioCategorizacion {
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public CriterioCategorizacion criterioPadre;
	public ArrayList<CriterioCategorizacion> criterioHijo = new ArrayList<CriterioCategorizacion>();
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
		categoria.setCriterio(this);
	}
}
