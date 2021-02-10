package persistencia;

import entidades.OSC;

public class OSCMapperBD extends MapperBD<OSC>{
	private static final OSCMapperBD instance = new OSCMapperBD();
	
	private OSCMapperBD () {}
	public static OSCMapperBD getInstance() {
		return instance;
	}
}