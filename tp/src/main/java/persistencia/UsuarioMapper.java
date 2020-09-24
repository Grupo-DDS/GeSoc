package persistencia;

import validadorDeCompras.Usuario;

public class UsuarioMapper  extends MapperBD<Usuario>{
	private static final UsuarioMapper instance = new UsuarioMapper();
	
	private UsuarioMapper () {}
	public static UsuarioMapper getInstance() {
		return instance;
	}
}
