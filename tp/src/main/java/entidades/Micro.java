package entidades;

import javax.persistence.Entity;


@Entity(name="Micro")
public class Micro extends Empresa{
	//@Id
  	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idMicro;
	
	public Micro() {}

	public int getIdMicro() {
		return idMicro;
	}

	public void setIdMicro(int idMicro) {
		this.idMicro = idMicro;
	}
}
