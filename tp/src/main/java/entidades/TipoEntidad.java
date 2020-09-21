package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity(name="TipoEntidad")
public class TipoEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoEntidad;
	
	public TipoEntidad() {}

	public int getIdTipoEntidad() {
		return idTipoEntidad;
	}

	public void setIdTipoEntidad(int idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}
	
}
