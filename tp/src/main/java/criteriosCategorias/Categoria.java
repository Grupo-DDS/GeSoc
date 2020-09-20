package criteriosCategorias;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


@Entity
//@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Categoria {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	private CriterioCategorizacion criterio;
	
	public CriterioCategorizacion getCriterio() {
		return criterio;
	}
	public void setCriterio(CriterioCategorizacion criterioCategorizacion) {
		this.criterio = criterioCategorizacion;
	}

}