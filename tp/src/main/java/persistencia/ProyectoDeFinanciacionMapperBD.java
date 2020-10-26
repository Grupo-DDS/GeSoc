package persistencia;


import RendicionDeCuentas.ProyectoDeFinanciacion;

public class ProyectoDeFinanciacionMapperBD extends MapperBD<ProyectoDeFinanciacion>  {
	private static final ProyectoDeFinanciacionMapperBD instance = new ProyectoDeFinanciacionMapperBD();
	
	private ProyectoDeFinanciacionMapperBD() {}
	public static ProyectoDeFinanciacionMapperBD getInstance() {
		return instance;
	}
}
