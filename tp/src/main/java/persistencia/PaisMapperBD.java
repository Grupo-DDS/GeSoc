package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.API.Pais;

public class PaisMapperBD {
	public void insert(List<Pais> paises) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		int index = 0;
		int size = paises.size();
		while(index<size) {
			Pais pais = paises.get(index);
			em.persist(pais);
			index++;
		}
			
		BDUtils.commit(em);		
	}
}
