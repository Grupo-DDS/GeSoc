package general;

import java.util.ArrayList;

public class NotificarRevisores {

	
	public void notificar(ArrayList<Usuario> revisores,Mensaje mensaje){
		revisores.stream().forEach(revisor -> revisor.agregarMensaje(mensaje));
	}
}
