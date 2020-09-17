package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.API.Pais;
import com.API.Provincia;

public class ProvinciaMapperBD {
	public void insert(List<Provincia> provincias) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		int index = 0;
		int size = provincias.size();
		while(index<size) {
			Provincia provincia = provincias.get(index);
			em.persist(provincia);
			index++;
		}
			
		BDUtils.commit(em);		
	}
	
	public void update(Provincia p) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.merge(p);
		em.persist(p);
		
		BDUtils.commit(em);		
	}
}
