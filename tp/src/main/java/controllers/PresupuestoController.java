package controllers;

import java.util.HashMap;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class PresupuestoController {

	public static Route cargarPresupuesto = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		
		
		return ViewUtil.render(request, model, Path.Template.PRESUPUESTO);
	};
	
	public static Route cargarPresupuestoDetallado = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		
		
		return ViewUtil.render(request, model, Path.Template.PRESUPUESTO_DETALLADO);
	};
}
