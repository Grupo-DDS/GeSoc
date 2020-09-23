package entidades;

import javax.persistence.Entity;


@Entity(name="MedianaTramo1")
public class MedianaTramo1 extends Empresa{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMedianaTramo1;
	
	public MedianaTramo1() {}

	
	public int getIdMedianaTramo1() {
		return idMedianaTramo1;
	}


	public void setIdMedianaTramo1(int idMedianaTramo1) {
		this.idMedianaTramo1 = idMedianaTramo1;
	}

}
