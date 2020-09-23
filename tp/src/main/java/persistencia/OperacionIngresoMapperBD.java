package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import egresosIngresos.OperacionEgreso;
import egresosIngresos.OperacionIngreso;
import egresosIngresos.Organizacion;

public class OperacionIngresoMapperBD extends MapperBD<OperacionIngreso>{
	private static final OperacionIngresoMapperBD instance = new OperacionIngresoMapperBD();
	
	private OperacionIngresoMapperBD () {}
	public static OperacionIngresoMapperBD getInstance() {
		return instance;
	}
	public List<OperacionIngreso> obtenerIngresosQueSeanVinculables(Organizacion organizacion){
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("select i from OperacionIngreso i where i.organizacion = :org and i.egresos is empty", OperacionIngreso.class)
					.setParameter("org", organizacion).getResultList();
	}
	
	public List<OperacionIngreso> obtenerIngresos(){
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		return em.createQuery("FROM OperacionIngreso", OperacionIngreso.class).getResultList();
	}
}
