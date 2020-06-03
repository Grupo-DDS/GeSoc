package general;
import java.util.ArrayList;

public class BandejaDeMensajes {
	static ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	public void agregarMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	public static ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}
	public static void setMensajes(ArrayList<Mensaje> mensajes) {
		BandejaDeMensajes.mensajes = mensajes;
	}
	
	public void mostrarMensajeAuxiliar(int posicion){
		Mensaje mensaje = mensajes.get(posicion);
		
		imprimirMensaje(mensaje);
	}
	
	void imprimirMensaje(Mensaje mensaje){
		
	if(mensaje.iscantidadPresupuestosIndicada())
		{System.out.println("Cantidad presupestos indicada TRUE");}
	else
		{System.out.println("Cantidad presupestos indicada FALSE");}
	
	if(mensaje.ispresupuestoElegido())
		{System.out.println("Presupesto elegido TRUE");}
	else
		{System.out.println("Presupesto elegido FALSE");}
	
	if(mensaje.isseleccionProveedor())
		{System.out.println("Seleccion proveedor TRUE");}
	else
		{System.out.println("Seleccion proveedor FALSE");}
	}
	
	
	private Mensaje findMensaje(Compra compra) {
		
	    Mensaje mensaje = null;
	    int index = 0;
	    while(index < mensajes.size()){
	    	if(compra.equals(mensajes.get(index).iscompra())){
	    		mensaje = mensajes.get(index);
	    		return mensaje;
	    	}
	    index++;
	    }
	    return mensaje;
	}
	
	public void mostrarMensaje(Usuario usuario) {
		Compra compra = usuario.getCompraRevisor();
		Mensaje mensaje = findMensaje(compra);
		if(mensaje!=null)
			imprimirMensaje(mensaje);	
	}
}
	

	
	

