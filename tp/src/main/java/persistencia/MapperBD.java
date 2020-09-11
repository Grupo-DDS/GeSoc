package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import comprasPresupuestos.Compra;

public class MapperBD {
	public void insert(Object o) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.persist(o);
		
		BDUtils.commit(em);		
	}
	
	public void insert(List<Object> objetos) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		int index = 0;
		int size = objetos.size();
		while(index<size) {
			Object objeto = objetos.get(index);
			em.persist(objeto);
			index++;
		}
			
		BDUtils.commit(em);		
	}
	
	public void update() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		BDUtils.commit(em);		
	}
	
	public void delete(Object o) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.remove(o);
		BDUtils.commit(em);	
	}
}
