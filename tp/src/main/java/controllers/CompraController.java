package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import app.Path;
import app.ViewUtil;
import comprasPresupuestos.Compra;
import comprasPresupuestos.Presupuesto;
import comprasPresupuestos.Producto;
import comprasPresupuestos.ProveedorMenorValor;
import spark.Request;
import spark.Response;
import spark.Route;
import validadorDeCompras.Usuario;

import static app.RequestUtil.getQueryCompra;
import static app.RequestUtil.getQueryCantidadPresupuestos;
import static app.RequestUtil.getQueryCriterioSeleccion;
import static app.RequestUtil.getQueryPresupuestosSeleccionados;
import static app.RequestUtil.getQueryProductosSeleccionados;
import static app.RequestUtil.getQueryPresupuestoElegido;
import static app.RequestUtil.getQueryUsername;
public class CompraController {
	public static Route cargarCompra = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		List<Presupuesto> presupuestos = Presupuesto.obtenerTodosEnBD();
		List<Producto> productos = Producto.obtenerTodosEnBD();
		model.put("presupuestos", presupuestos);
		model.put("productos", productos);
		LoginController.ensureUserIsLoggedIn(request, response);
		Compra compraNueva = new Compra();
		if (getQueryCompra(request) != null && getQueryCantidadPresupuestos(request) != null
				&& getQueryCriterioSeleccion(request) != null 
				 && getQueryPresupuestoElegido(request) != null) {

			Long numeroCompra;
			try {
				numeroCompra = Long.parseLong(getQueryCompra(request).trim());
			} catch (NumberFormatException e1) {
				model.put("FormatoNumeroCompraIncorrecto", true);
				return ViewUtil.render(request, model, Path.Template.COMPRA);
			}
			if (numeroCompra < 0) {
				model.put("NumeroCompraMenorACero", true);
				return ViewUtil.render(request, model, Path.Template.COMPRA);
			}

			if (Compra.buscarCompraPorNumeroEnBD(numeroCompra) != null) {
				model.put("NumeroCompraYaExiste", true);
				return ViewUtil.render(request, model, Path.Template.COMPRA);
			}
			compraNueva.setNumeroCompra(numeroCompra);

			Integer cantidadPresupuestos;
			try {
				cantidadPresupuestos = Integer.parseInt(getQueryCantidadPresupuestos(request).trim());
			} catch (NumberFormatException e1) {
				model.put("FormatoCantidadIncorrecto", true);
				return ViewUtil.render(request, model, Path.Template.CARGAR_PROYECTO);
			}
			if (cantidadPresupuestos < 0) {
				model.put("cantidadMenorACero", true);
				return ViewUtil.render(request, model, Path.Template.CARGAR_PROYECTO);
			}
			compraNueva.setCantidadMinimaPresupuestos(cantidadPresupuestos);

			if (getQueryCriterioSeleccion(request).equals("ProveedorMenorValor"))
				compraNueva.setCriterio(ProveedorMenorValor.getInstance());
			if(getQueryPresupuestosSeleccionados(request) != null){
			String[] identificadoresPresupuestosSeleccionados = getQueryPresupuestosSeleccionados(request);
			List<Presupuesto> presupuestosSeleccionados = filtrarPresupuestosPorIdentificadores(presupuestos,
					identificadoresPresupuestosSeleccionados);
			compraNueva.setPresupuestos(presupuestosSeleccionados);
			}
			
			if(getQueryProductosSeleccionados(request) != null){
			String[] identificadoresProductosSeleccionados = getQueryProductosSeleccionados(request);
			List<Producto> productosSeleccionados = filtrarProductosPorIdentificadores(productos,
					identificadoresProductosSeleccionados);
			compraNueva.setProductos(productosSeleccionados);
			}
			Long identificadorPresupuestoElegido = Long.parseLong(getQueryPresupuestoElegido(request));
			List<Presupuesto> presupuestoElegido = presupuestos.stream()
					.filter(presupuesto -> presupuesto.getId() == identificadorPresupuestoElegido)
					.collect(Collectors.toList());
			compraNueva.setPresupuestoElegido(presupuestoElegido.get(0));
			
			compraNueva.getRevisores().add(Usuario.buscarUsuarioBD(getQueryUsername(request)));
			Compra.insertarNuevaCompraEnBD(compraNueva);
			model.put("cargaCompraExitosa", true);
		}

		return ViewUtil.render(request, model, Path.Template.COMPRA);
	};

	private static List<Presupuesto> filtrarPresupuestosPorIdentificadores(List<Presupuesto> presupuestos,
			String[] identificadoresPresupuestosSeleccionados) {
		List<Presupuesto> presupuestosFiltrados = new ArrayList<Presupuesto>();
		for (Presupuesto presupuesto : presupuestos) {
			int index = 0;
			int longitud = identificadoresPresupuestosSeleccionados.length;
			while (index < longitud) {
				Long identificador = Long.parseLong(identificadoresPresupuestosSeleccionados[index]);
				if (presupuesto.getId() == identificador) {
					presupuestosFiltrados.add(presupuesto);
					break;
				}
				index++;
			}
		}
		return presupuestosFiltrados;
	}

	private static List<Producto> filtrarProductosPorIdentificadores(List<Producto> productos,
			String[] identificadoresProductosSeleccionados) {
		List<Producto> productosFiltrados = new ArrayList<Producto>();
		for (Producto producto : productos) {
			int index = 0;
			int longitud = identificadoresProductosSeleccionados.length;
			while (index < longitud) {
				Long identificador = Long.parseLong(identificadoresProductosSeleccionados[index]);
				if (producto.getId() == identificador) {
					productosFiltrados.add(producto);
					break;
				}
				index++;
			}
		}
		return productosFiltrados;
	}
}
