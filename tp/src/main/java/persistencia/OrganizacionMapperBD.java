package persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import egresosIngresos.Organizacion;

public class OrganizacionMapperBD extends MapperBD<Organizacion>{

public List<Organizacion> obtenerOrganizaciones() {
		EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
		@SuppressWarnings("unchecked")
		List<Organizacion> organizaciones = (List<Organizacion>) em.createQuery("select p from Organizacion").getResultList();
		return organizaciones;
}
}
