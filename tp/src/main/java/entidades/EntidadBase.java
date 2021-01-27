package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import persistencia.EntidadBaseMapperBD;

@Entity(name = "EntidadBase")
public class EntidadBase extends Entidad {
	
	@ManyToOne
	private EntidadJuridica entidad_juridica;
	private String descripcion;
	
	public EntidadBase() {
	}

	public EntidadJuridica getEntidad_juridica() {
		return entidad_juridica;
	}

	public void setEntidad_juridica(EntidadJuridica entidad_juridica) {
		this.entidad_juridica = entidad_juridica;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static List<EntidadBase> obtenerTodosSinAsignar() {
		return EntidadBaseMapperBD.getInstance().obtenerTodosSinAsignar();
	}

	public static void insertarNuevaBase(EntidadBase entidad) {
		EntidadBaseMapperBD.getInstance().insert(entidad);
	}

}
