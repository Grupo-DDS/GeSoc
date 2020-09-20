package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="EntidadBase")
public class EntidadBase extends Entidad{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idEntidadBase;
	String descripcion;
	public EntidadBase() {}
	
	public int getIdEntidadBase() {
		return idEntidadBase;
	}
	public void setIdEntidadBase(int idEntidadBase) {
		this.idEntidadBase = idEntidadBase;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
