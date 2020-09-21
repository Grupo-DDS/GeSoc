package validadorDeCompras;

import java.util.ArrayList;

import javax.persistence.Entity;

import criteriosCategorias.CriterioCategorizacion;

@Entity
public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasenia, ArrayList<Mensaje> bandejaDeMensajes) {
		super(nombre, contrasenia, bandejaDeMensajes);
		// TODO Auto-generated constructor stub
	}
	public void otorgarJerarquia(CriterioCategorizacion padre, CriterioCategorizacion hijo) {
	padre.criterioHijo.add(hijo);
	hijo.criterioPadre=padre;	
        }

}
