package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.API.Ciudad;

public class CiudadMapperBD {
	public void insert(Ciudad c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.persist(c);
		
		BDUtils.commit(em);		
	}
	
	public void insert(List<Ciudad> ciudades) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		int index = 0;
		int size = ciudades.size();
		while(index<size) {
			Ciudad ciudad = ciudades.get(index);
			em.persist(ciudad);
			index++;
		}
			
		BDUtils.commit(em);	
	}
	
	public void update(Ciudad c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.merge(c);
		BDUtils.commit(em);		
	}
	
	public void delete(Ciudad c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.remove(c);
		BDUtils.commit(em);	
	}
	
	public Object obtenerCiudad(Long id) {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.find(Ciudad.class,id);	
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> obtenerCiudades() {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM Ciudad").getResultList();
	}
}
