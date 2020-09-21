package criteriosCategorias;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
//@Table(name = "USUARIO")

public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private CriterioCategorizacion criterio;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public CriterioCategorizacion getCriterio() {
		return criterio;
	}
	public void setCriterio(CriterioCategorizacion criterioCategorizacion) {
		this.criterio = criterioCategorizacion;
	}

}