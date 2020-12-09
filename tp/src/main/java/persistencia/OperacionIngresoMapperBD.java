package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import egresosIngresos.OperacionIngreso;

public class OperacionIngresoMapperBD extends MapperBD<OperacionIngreso> {
	private static final OperacionIngresoMapperBD instance = new OperacionIngresoMapperBD();

	private OperacionIngresoMapperBD() {
	}

	public static OperacionIngresoMapperBD getInstance() {
		return instance;
	}

	public List<OperacionIngreso> obtenerIngresosQueSeanVinculables() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("select i from OperacionIngreso i where i.egresos is empty", OperacionIngreso.class)
				.getResultList();
	}

	public List<OperacionIngreso> obtenerIngresos() {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM OperacionIngreso", OperacionIngreso.class).getResultList();
	}
}
