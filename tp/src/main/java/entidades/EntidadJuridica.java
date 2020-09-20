package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="EntidadJuridica")
public class EntidadJuridica extends Entidad{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigoInscripcion;
	int codigoPostal;
	int cuit;
	
	@OneToMany(mappedBy="EntidadJuridica")
	private ArrayList<EntidadBase> entidades = new ArrayList<EntidadBase>(); 
	
	String razonSocial;
	
	public EntidadJuridica(int codigoInscripcion, int codigoPostal, int cuit, ArrayList<EntidadBase> entidades,
			String razonSocial) {
		super();
		this.codigoInscripcion = codigoInscripcion;
		this.codigoPostal = codigoPostal;
		this.cuit = cuit;
		this.entidades = entidades;
		this.razonSocial = razonSocial;
	}

	public EntidadJuridica() {}
	
	public int getCodigoInscripcion() {
		return codigoInscripcion;
	}
	public void setCodigoInscripcion(int codigoInscripcion) {
		this.codigoInscripcion = codigoInscripcion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public ArrayList<EntidadBase> getEntidades() {
		return entidades;
	}
	public void setEntidades(ArrayList<EntidadBase> entidades) {
		this.entidades = entidades;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
}
