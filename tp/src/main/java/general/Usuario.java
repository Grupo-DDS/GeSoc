package general;

import java.util.ArrayList;

public class Usuario {

	public Usuario(String nombre, String contrasenia, ArrayList<Mensaje> bandejaDeMensajes) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.bandejaDeMensajes = bandejaDeMensajes;
	}

	String nombre;
	String contrasenia;
	ArrayList<Mensaje> bandejaDeMensajes = new ArrayList<Mensaje>();

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void agregarMensaje(Mensaje mensaje){
		bandejaDeMensajes.add(mensaje);
	}
		
}
