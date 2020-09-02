package validadorContrasenias;

import validadorDeCompras.Usuario;

public class RegistrarUsuario {
Usuario registrar(String nombre, String contrasenia) {
		if(ValidadorContrasenias.validar(contrasenia))
			return new Usuario(nombre,contrasenia,null);
		else
			return null;
	}
}
