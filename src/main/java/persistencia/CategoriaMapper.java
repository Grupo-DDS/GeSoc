package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import criteriosCategorias.Categoria;

public class CategoriaMapper extends MapperBD<Categoria>{
	private static final CategoriaMapper instance = new CategoriaMapper();
	
	private CategoriaMapper () {}
	public static CategoriaMapper getInstance() {
		return instance;
	}
	public Categoria buscarCategoriaPorID(Long idCategoriaParseada) {
		EntityManager em = BDUtils.getEntityManager();
		BDUtils.comenzarTransaccion(em);
		Categoria categoriaEncontrada;
		try {
			categoriaEncontrada = em.createQuery("select c from Categoria c where c.id = :idCategoriaParseada", Categoria.class)
					.setParameter("idCategoriaParseada", idCategoriaParseada).getSingleResult();
		}
		catch(NoResultException e) {
			categoriaEncontrada = null;
		}
		return categoriaEncontrada;
	}
}
