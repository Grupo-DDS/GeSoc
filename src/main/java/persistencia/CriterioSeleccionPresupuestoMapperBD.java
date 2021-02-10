package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import comprasPresupuestos.CriterioSeleccionPresupuesto;
import comprasPresupuestos.ProveedorMenorValor;

public class CriterioSeleccionPresupuestoMapperBD  extends MapperBD<CriterioSeleccionPresupuesto>{
	private static final CriterioSeleccionPresupuestoMapperBD instance = new CriterioSeleccionPresupuestoMapperBD();
	
	private CriterioSeleccionPresupuestoMapperBD () {}
	public static CriterioSeleccionPresupuestoMapperBD getInstance() {
		return instance;
	}
	public ProveedorMenorValor buscarCriterioMenorValor() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		ProveedorMenorValor critEncontrado;
		try {
			critEncontrado = em.createQuery("select c from CriterioSeleccionPresupuesto c where c.tipo like :n", ProveedorMenorValor.class)
					.setParameter("n", "menor valor").getSingleResult();
		}
		catch(NoResultException e) {
			critEncontrado = null;
		}
		return critEncontrado;
	}
}
