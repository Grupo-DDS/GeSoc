package persistencia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.API.Moneda;

import comprasPresupuestos.Compra;


public class CompraMapperBD {

	public void insert(Compra c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.persist(c);
		
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
	
	public void delete(Object c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.remove(c);
		BDUtils.commit(em);	
	}
	

}
