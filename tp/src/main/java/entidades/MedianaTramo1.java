package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="MedianaTramo1")
public class MedianaTramo1 extends Empresa{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMedianaTramo1;
	private static MedianaTramo1 instance = null;
	
	public MedianaTramo1() {}

	
	public int getIdMedianaTramo1() {
		return idMedianaTramo1;
	}


	public void setIdMedianaTramo1(int idMedianaTramo1) {
		this.idMedianaTramo1 = idMedianaTramo1;
	}


	public static MedianaTramo1 getInstance() {
		if (instance == null)
			instance = new MedianaTramo1();
		return instance;
	}
}
