package validadorDeCompras;


import java.util.List;

public class NotificarRevisores {

	private static NotificarRevisores instance = null;
	
	private NotificarRevisores() {}
	
	public static NotificarRevisores getInstance()
	{
	if (instance == null)
	instance = new NotificarRevisores();
	return instance;
	}
	
	public void notificar(List<Usuario> revisores,Mensaje mensaje){
		revisores.stream().forEach(revisor -> revisor.agregarMensaje(mensaje));
	}
}
