package controllers;

import static app.RequestUtil.getQueryDescripcion;
import static app.RequestUtil.getQueryFecha;
import static app.RequestUtil.getQueryMontoTotal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import comprasPresupuestos.PresupuestoDetallado;
import spark.Request;
import spark.Response;
import spark.Route;

public class InstanciarEmpresaController {
	public static Route instanciarEmpresa = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		List<PresupuestoDetallado> presupuestos = PresupuestoDetallado.obtenerTodosEnBD();
		model.put("presupuestos", presupuestos);
		//LoginController.ensureUserIsLoggedIn(request, response);

		return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
	};

}
