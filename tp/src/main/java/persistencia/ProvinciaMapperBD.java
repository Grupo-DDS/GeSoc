package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.API.Pais;
import com.API.Provincia;

public class ProvinciaMapperBD {
	public void insert(Object o) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.persist(o);
		
		BDUtils.commit(em);		
	}
	
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
		
		BDUtils.commit(em);		
	}
	
	public void delete(Provincia provincia) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.remove(provincia);
		BDUtils.commit(em);	
	}
	
	public Provincia obtenerProvincia(Long id) {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.find(Provincia.class,id);	
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Provincia> obtenerProvincias() {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM Provincia").getResultList();
	}
}
