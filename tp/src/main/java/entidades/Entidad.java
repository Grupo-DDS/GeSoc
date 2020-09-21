package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity (name="Entidad")

public class Entidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idEntidad;
	String nombreFicticio;
	
	@OneToOne
	@JoinColumn(name = "id_entidad")
	TipoEntidad tipoDeEntidad;
	
	public Entidad() {}
	
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}
	public TipoEntidad getTipoDeEntidad() {
		return tipoDeEntidad;
	}
	public void setTipoDeEntidad(TipoEntidad tipoDeEntidad) {
		this.tipoDeEntidad = tipoDeEntidad;
	}
}
