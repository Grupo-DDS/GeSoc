package entidades;

import javax.persistence.Entity;


@Entity(name="OSC")
public class OSC extends TipoEntidad{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idOSC;
	private static OSC instance = null;
	
	public OSC() {}
	public int getIdOSC() {
		return idOSC;
	}
	public void setIdOSC(int idOSC) {
		this.idOSC = idOSC;
	}
	
	public static OSC getInstance() {
		if (instance == null)
			instance = new OSC();
		return instance;
	}
	
}
