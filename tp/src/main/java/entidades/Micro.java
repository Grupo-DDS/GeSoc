package entidades;

import javax.persistence.Entity;


@Entity(name="Micro")
public class Micro extends Empresa{
	//@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMicro;
	private static Micro instance = null;
	
	public Micro() {}

	public int getIdMicro() {
		return idMicro;
	}

	public void setIdMicro(int idMicro) {
		this.idMicro = idMicro;
	}
	public static Micro getInstance() {
		if (instance == null)
			instance = new Micro();
		return instance;
	}
}
