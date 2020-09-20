package validadorDeCompras;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
@Entity
//@Table(name = "USUARIO")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	String nombre;
	String contrasenia;
	ArrayList<Mensaje> bandejaDeMensajes = new ArrayList<Mensaje>();
	
	
	public Usuario(String nombre, String contrasenia, ArrayList<Mensaje> bandejaDeMensajes) {
		
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.bandejaDeMensajes = bandejaDeMensajes;
	}

	public Long getId(){
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
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
