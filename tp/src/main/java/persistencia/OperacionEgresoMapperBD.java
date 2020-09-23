package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import egresosIngresos.OperacionEgreso;
import egresosIngresos.Organizacion;

public class OperacionEgresoMapperBD extends MapperBD<OperacionEgreso>{
private static final OperacionEgresoMapperBD instance = new OperacionEgresoMapperBD();
	
	private OperacionEgresoMapperBD () {}
	public static OperacionEgresoMapperBD getInstance() {
		return instance;
	}
	public List<OperacionEgreso> obtenerEgresosQueSeanVinculables(Organizacion organizacion){
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("select e from OperacionEgreso e where e.organizacion = :org and e.ingreso is null", OperacionEgreso.class)
					.setParameter("org", organizacion).getResultList();
	}
	
	public List<OperacionEgreso> obtenerEgresos(){
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM OperacionEgreso", OperacionEgreso.class).getResultList();
	}
	
}
