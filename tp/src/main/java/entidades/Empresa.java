package entidades;

import javax.persistence.Entity;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity(name="Empresa")

public class Empresa extends TipoEntidad{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idEmpresa;
	int personal;
	int vtasAnuales;
	String actividad;
	
	public Empresa () {}
 	
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public int getVtasAnuales() {
		return vtasAnuales;
	}
	public void setVtasAnuales(int vtasAnuales) {
		this.vtasAnuales = vtasAnuales;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
}
