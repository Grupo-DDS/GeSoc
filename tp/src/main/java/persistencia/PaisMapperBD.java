package persistencia;

import com.API.Pais;

public class PaisMapperBD extends MapperBD <Pais>{
	private static final PaisMapperBD instance = new PaisMapperBD();
	
	private PaisMapperBD () {}
	public static PaisMapperBD getInstance() {
		return instance;
	}
}
