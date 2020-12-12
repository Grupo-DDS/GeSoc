package controllers;

import static app.RequestUtil.getQueryMontoTotal;
import static app.RequestUtil.getQueryProductoSeleccionado;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.Path;
import app.ViewUtil;
import comprasPresupuestos.PresupuestoDetallado;
import comprasPresupuestos.Producto;
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
		List<Producto> productos = Producto.obtenerTodosEnBD();
		model.put("productos", productos);
		
		if(getQueryMontoTotal(request)!=null && getQueryProductoSeleccionado(request) !=null) {
		Float montoTotal;
		try {
			montoTotal = Float.parseFloat(getQueryMontoTotal(request).trim());
		} catch (NumberFormatException e1) {
			model.put("FormatoNumeroIncorrecto", true);
			return ViewUtil.render(request, model, Path.Template.PRESUPUESTO_DETALLADO);
		}
		if (montoTotal <= 0) {
			model.put("montoMenorACero", true);
			return ViewUtil.render(request, model, Path.Template.PRESUPUESTO_DETALLADO);
		}
		
		
		Long identificadorProductoElegido = Long.parseLong(getQueryProductoSeleccionado(request));		
		Producto productoElegido = productos.stream()
				.filter(producto -> producto.getId() == identificadorProductoElegido)
				.collect(Collectors.toList()).get(0);
		
		PresupuestoDetallado presupuestoDetalladoNuevo = new PresupuestoDetallado(montoTotal, productoElegido);
		PresupuestoDetallado.insertarNuevoPDEnBD(presupuestoDetalladoNuevo);
		model.put("cargaCorrecta", true);		
		model.put("numeroPresupuesto", presupuestoDetalladoNuevo.getId());
		
		}

		
		
		
		
		return ViewUtil.render(request, model, Path.Template.PRESUPUESTO_DETALLADO);
	};
}
