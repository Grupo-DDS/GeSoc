package controllers;

import static app.RequestUtil.getQueryCantidadCategorias;
import static app.RequestUtil.getQueryNombreCategorias;
import static app.RequestUtil.getQueryNombreCriterio;
import static app.RequestUtil.getQueryNombreCriterioPadre;

import java.util.HashMap;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import criteriosCategorias.Categoria;
import criteriosCategorias.CriterioCategorizacion;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProductoController {
	public static Route cargarProducto = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);

		return ViewUtil.render(request, model, Path.Template.PRODUCTOS);
	};

	public static Route cargarCategoria1 = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		// LoginController.ensureUserIsLoggedIn(request, response);

		if (getQueryCantidadCategorias(request) != null && getQueryNombreCriterio(request) != null) {

			if (getQueryNombreCriterio(request).equals("")) {
				model.put("nombreCriterioVacio", true);
				return ViewUtil.render(request, model, Path.Template.CATEGORIA);
			}

			CriterioCategorizacion criterioEncontrado = CriterioCategorizacion
					.buscarCriterioPorNombreEnBD(getQueryNombreCriterio(request).trim());
			if (criterioEncontrado != null) {
				model.put("nombreCriterioYaExiste", true);
				return ViewUtil.render(request, model, Path.Template.CATEGORIA);
			}

			CriterioCategorizacion criterioPadreEncontrado = null;
			if (!getQueryNombreCriterioPadre(request).equals("")) {
				criterioPadreEncontrado = CriterioCategorizacion
						.buscarCriterioPorNombreEnBD(getQueryNombreCriterioPadre(request).trim());
				if (criterioPadreEncontrado == null) {
					model.put("nombreCriterioPadreNoExiste", true);
					return ViewUtil.render(request, model, Path.Template.CATEGORIA);
				}
			}
			CriterioCategorizacion criterioNuevo = new CriterioCategorizacion();
			criterioNuevo = new CriterioCategorizacion();

			criterioNuevo.setCriterioPadre(criterioPadreEncontrado);
			criterioNuevo.setNombre(getQueryNombreCriterio(request).trim());
			int cantidadCategorias = Integer.parseInt(getQueryCantidadCategorias(request));
			int index = 0;
			while (index < cantidadCategorias) {
				Categoria categoriaNueva = new Categoria();
				categoriaNueva.setCriterio(criterioNuevo);
				criterioNuevo.getCategorias().add(categoriaNueva);
				index++;
			}

			CriterioCategorizacion.insertarNuevoCriterioEnBD(criterioNuevo);

			if (criterioPadreEncontrado != null) {
				criterioPadreEncontrado.getCriterioHijo().add(criterioNuevo);
				CriterioCategorizacion.actualizarCriterioEnBD(criterioPadreEncontrado);
			}
			model.put("criterio", criterioNuevo);
			model.put("categorias", criterioNuevo.getCategorias());
		} else {
			if (getQueryNombreCategorias(request) != null) {
				CriterioCategorizacion cr = CriterioCategorizacion
						.buscarCriterioPorNombreEnBD(getQueryNombreCategorias(request)[0]);
				int index = 1;
				int length = getQueryNombreCategorias(request).length;
				while (index < length) {
					cr.getCategorias().get(index-1).setNombre(getQueryNombreCategorias(request)[index]);
					index++;
				}
				Categoria.actualizarCategorias(cr.getCategorias());
				model.put("criterio", null);
				model.put("criterioCargado", true);

			}

		}

		return ViewUtil.render(request, model, Path.Template.CATEGORIA);

	};


}
