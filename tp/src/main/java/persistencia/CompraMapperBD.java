package persistencia;

import javax.persistence.EntityManager;
import comprasPresupuestos.Compra;

public class CompraMapperBD {

	public void insert(Compra c) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		em.persist(c);
		BDUtils.commit(em);		
	}
	
	public void update() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		BDUtils.commit(em);		
	}
	
	public void delete(Compra c) {
	EntityManager em = BDUtils.getEntityManager();
	BDUtils.comenzarTransaccion(em);
	em.remove(c);
	BDUtils.commit(em);	
	}
}
