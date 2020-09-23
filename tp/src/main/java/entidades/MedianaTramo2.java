package entidades;

import javax.persistence.Entity;

@Entity(name="MedianaTramo2")
public class MedianaTramo2 extends Empresa{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMedianaTramo2;

	public MedianaTramo2() {}

	public int getIdMedianaTramo2() {
		return idMedianaTramo2;
	}

	public void setIdMedianaTramo2(int idMedianaTramo2) {
		this.idMedianaTramo2 = idMedianaTramo2;
	}
}
