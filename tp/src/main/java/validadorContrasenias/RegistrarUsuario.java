package validadorContrasenias;

import org.mindrot.jbcrypt.BCrypt;

import persistencia.UsuarioMapper;
import validadorDeCompras.Usuario;

public class RegistrarUsuario {
	public void registrar(String nombre, String contrasenia) {
		String newSalt = BCrypt.gensalt();
		String newHashedPassword = BCrypt.hashpw(newSalt, contrasenia);
		Usuario u = new Usuario(nombre, newSalt, newHashedPassword, null);
		UsuarioMapper.getInstance().insert(u);
	}

}
