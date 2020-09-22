package persistencia;

import java.io.IOException;
import java.util.List;

import com.API.Ciudad;
import com.API.Moneda;
import com.API.Pais;
import com.API.Provincia;

public class PersistenciaAPI {
	public void cargarTodo() throws IOException {
		Moneda m = new Moneda();
		MonedaMapperBD mbd = new MonedaMapperBD();
		List<Moneda> monedas = m.obtenerListaAPI();
		mbd.save(monedas);
		
		Pais p = new Pais();
		PaisMapperBD pbd = new PaisMapperBD();
		List<Pais> paises = p.obtenerPaises();
		List<Pais> paisesDetallados = p.obtenerPaisesDetallados(paises);
		
		Provincia pr = new Provincia();
		int index = 0;
		int size = paisesDetallados.size();
		while(index<size) {
			List<Provincia> provinciasPais = paisesDetallados.get(index).getStates();
			List<Provincia> provinciasDetalladas = pr.obtenerProvinciasDetalladas(provinciasPais);
			paisesDetallados.get(index).setStates(provinciasDetalladas);
			index++;
		}
		
		Ciudad c = new Ciudad();
		int i = 0;
		int j = 0;
		while(i<size) {
			int sizeProvincia = paisesDetallados.get(i).getStates().size();
			while(j<sizeProvincia) {
				Provincia pj = paisesDetallados.get(i).getStates().get(j);
				List<Ciudad> ciudadesDetalladas = c.obtenerCiudadesDetalladas(pj.getCities());
				pj.setCities(ciudadesDetalladas);
				j++;
			}
			i++;
		}
		pbd.save(paisesDetallados);
		

		
		//prbd.insert(paises.get(0).getStates());
		
		
//		List <Moneda> monedasbd = mbd.obtenerMonedas();
//		int i = 0;
//		int size = monedasbd.size();
//		while(i<size) {
//			System.out.println("Moneda "+i+" "+monedasbd.get(i).toString());
//			i++;
//		}
//		
//		Moneda monedaEncontrada = mbd.obtenerMoneda("ARS");
//		if(monedaEncontrada!=null)
//			System.out.println("MONEDA ENCONTRADAAAA "+i+" "+monedaEncontrada.toString());
	}
}
