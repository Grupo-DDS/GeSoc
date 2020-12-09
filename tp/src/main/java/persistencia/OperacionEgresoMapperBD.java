package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import egresosIngresos.OperacionEgreso;

public class OperacionEgresoMapperBD extends MapperBD<OperacionEgreso> {
	private static final OperacionEgresoMapperBD instance = new OperacionEgresoMapperBD();

	private OperacionEgresoMapperBD() {
	}

	public static OperacionEgresoMapperBD getInstance() {
		return instance;
	}

	public List<OperacionEgreso> obtenerEgresosQueSeanVinculables() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("select e from OperacionEgreso e where e.ingreso is null", OperacionEgreso.class)
				.getResultList();
	}

	public List<OperacionEgreso> obtenerEgresos() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("SELECT E FROM OperacionEgreso E JOIN FETCH E.ingreso i", OperacionEgreso.class)
				.getResultList();
	}

}
