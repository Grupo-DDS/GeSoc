package validadorDeCompras;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Estandar extends Usuario {

	public Estandar(String nombre, String contrasenia, ArrayList<Mensaje> bandejaDeMensajes) {
		super(nombre, contrasenia, bandejaDeMensajes);
		// TODO Auto-generated constructor stub
	}

}
