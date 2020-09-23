package entidades;

import javax.persistence.Entity;

@Entity(name="Pequenia")
public class Pequenia extends Empresa{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idPequenia;

	public Pequenia() {}

	public int getIdPequenia() {
		return idPequenia;
	}

	public void setIdPequenia(int idPequenia) {
		this.idPequenia = idPequenia;
	}
}
