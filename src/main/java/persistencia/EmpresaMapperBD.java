package persistencia;

import entidades.Empresa;

public class EmpresaMapperBD extends MapperBD<Empresa>{
	private static final EmpresaMapperBD instance = new EmpresaMapperBD();
	
	private EmpresaMapperBD () {}
	public static EmpresaMapperBD getInstance() {
		return instance;
	}
}