package controllers;

import java.util.HashMap;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

public class ProyectoController {
	public static Route IndexProyecto = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		return ViewUtil.render(request, model, Path.Template.PROYECTO);
	};
	public static Route cargarProyecto = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		return ViewUtil.render(request, model, Path.Template.CARGAR_PROYECTO);
	};
	public static Route vincularProyecto = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		return ViewUtil.render(request, model, Path.Template.VINCULAR_PROYECTO);
	};
}
