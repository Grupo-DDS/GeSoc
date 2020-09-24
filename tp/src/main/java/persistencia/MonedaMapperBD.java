package persistencia;


import com.API.Moneda;

public class MonedaMapperBD extends MapperBD<Moneda> {	
	private static final MonedaMapperBD instance = new MonedaMapperBD();
	
	private MonedaMapperBD () {}
	public static MonedaMapperBD getInstance() {
		return instance;
	}
}
