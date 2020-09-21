package entidades;

import javax.persistence.Entity;


@Entity(name="EntidadBase")
public class EntidadBase extends Entidad{

	private String descripcion;
	public EntidadBase() {}
	

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
