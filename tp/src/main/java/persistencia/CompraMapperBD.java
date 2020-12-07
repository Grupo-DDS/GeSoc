package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import comprasPresupuestos.Compra;


public class CompraMapperBD extends MapperBD<Compra>{

	private static final CompraMapperBD instance = new CompraMapperBD();
	
	private CompraMapperBD () {}
	public static CompraMapperBD getInstance() {
		return instance;
	}
	
	
	public Compra buscarCompraPorNumero(Long numeroCompra) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		Compra compraEncontrada;
		try {
			compraEncontrada = em.createQuery("select c from Compra c where c.numeroCompra = :n", Compra.class)
					.setParameter("n", numeroCompra).getSingleResult();
		}
		catch(NoResultException e) {
			compraEncontrada = null;
		}
		return compraEncontrada;
	}
}