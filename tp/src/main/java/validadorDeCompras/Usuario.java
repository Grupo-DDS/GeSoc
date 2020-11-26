package validadorDeCompras;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import persistencia.UsuarioMapper;
@Entity
//@Table(name = "USUARIO")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	String nombre;
    String salt;
    String hashedPassword;
	ArrayList<Mensaje> bandejaDeMensajes = new ArrayList<Mensaje>();
	
	
	public Usuario() {

	}

	public Usuario(String nombre, String salt, String hashedPassword, ArrayList<Mensaje> bandejaDeMensajes) {
		super();
		this.nombre = nombre;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
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

	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public ArrayList<Mensaje> getBandejaDeMensajes() {
		return bandejaDeMensajes;
	}
	public void setBandejaDeMensajes(ArrayList<Mensaje> bandejaDeMensajes) {
		this.bandejaDeMensajes = bandejaDeMensajes;
	}
	public void agregarMensaje(Mensaje mensaje){
		bandejaDeMensajes.add(mensaje);
	}
	
	public Usuario buscarUsuarioBD(String nombre) {
		return UsuarioMapper.getInstance().buscarUsuario(nombre);
	}

	public void crearUsuario(String username, String password) {
		// TODO Auto-generated method stub
		
	}
		
}
