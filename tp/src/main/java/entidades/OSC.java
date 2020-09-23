package entidades;

import javax.persistence.Entity;


@Entity(name="OSC")
public class OSC extends TipoEntidad{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idOSC;
	
	public OSC() {}
	public int getIdOSC() {
		return idOSC;
	}
	public void setIdOSC(int idOSC) {
		this.idOSC = idOSC;
	}
}
