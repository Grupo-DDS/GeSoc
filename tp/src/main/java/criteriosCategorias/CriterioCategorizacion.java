package criteriosCategorias;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


@Entity
//@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class CriterioCategorizacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public CriterioCategorizacion getCriterioPadre() {
		return criterioPadre;
	}

	public void setCriterioPadre(CriterioCategorizacion criterioPadre) {
		this.criterioPadre = criterioPadre;
	}

	public ArrayList<CriterioCategorizacion> getCriterioHijo() {
		return criterioHijo;
	}

	public void setCriterioHijo(ArrayList<CriterioCategorizacion> criterioHijo) {
		this.criterioHijo = criterioHijo;
	}

	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public CriterioCategorizacion criterioPadre;
	public ArrayList<CriterioCategorizacion> criterioHijo = new ArrayList<CriterioCategorizacion>();
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
		categoria.setCriterio(this);
	}
}
