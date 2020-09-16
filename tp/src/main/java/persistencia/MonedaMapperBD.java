package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.API.Moneda;

public class MonedaMapperBD {
	public void insert(List<Moneda> monedas) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		int index = 0;
		int size = monedas.size();
		while(index<size) {
			Moneda moneda = monedas.get(index);
			em.persist(moneda);
			index++;
		}
			
		BDUtils.commit(em);	
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Moneda> obtenerMonedas() {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM Moneda").getResultList();
	}
	
	public Moneda obtenerMoneda(String id) {		
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.find(Moneda.class,id);	
	}
	
}
