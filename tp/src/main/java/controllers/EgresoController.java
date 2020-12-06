package controllers;

import static app.RequestUtil.getQueryCompra;
import static app.RequestUtil.getQueryComprobanteNumero;
import static app.RequestUtil.getQueryComprobanteTipo;
import static app.RequestUtil.getQueryDNICUITProveedor;
import static app.RequestUtil.getQueryNombreProveedor;
import static app.RequestUtil.getQueryFecha;
import static app.RequestUtil.getQueryMedio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import comprasPresupuestos.Compra;
import egresosIngresos.DocumentoComercial;
import egresosIngresos.MedioDePago;
import egresosIngresos.OperacionEgreso;
import egresosIngresos.OrganizacionProveedora;
import egresosIngresos.Persona;
import persistencia.CompraMapperBD;
import persistencia.DocumentoComercialMapperBD;
import persistencia.MedioDePagoMapperBD;
import persistencia.OperacionEgresoMapperBD;
import persistencia.ProveedorMapperBD;
import spark.Request;
import spark.Response;
import spark.Route;

public class EgresoController {
	public static Route cargarEgreso = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		LoginController.ensureUserIsLoggedIn(request, response);
		OperacionEgreso nuevaOperacionEgreso = new OperacionEgreso();
		try {
			if (!getQueryCompra(request).equals("") && !getQueryComprobanteTipo(request).equals("")
					&& !getQueryFecha(request).equals("") && !getQueryMedio(request).equals("")
					&& !getQueryNombreProveedor(request).equals("") && !getQueryDNICUITProveedor(request).equals("")
					&& !getQueryComprobanteNumero(request).equals("")) {
				Compra compraEncontrada = CompraMapperBD.getInstance()
						.buscarCompraPorNumero(Long.parseLong(getQueryCompra(request).trim()));
				if (compraEncontrada != null)
					nuevaOperacionEgreso.setCompra(compraEncontrada);
				else {
					model.put("compraInexistente", true);
					return ViewUtil.render(request, model, Path.Template.EGRESOS);
				}
				if (getQueryComprobanteTipo(request).trim().length() == 1) {
					DocumentoComercial comprobante = new DocumentoComercial(
							Integer.parseInt(getQueryComprobanteNumero(request).trim()),
							getQueryComprobanteTipo(request).trim().charAt(0));
					DocumentoComercialMapperBD.getInstance().insert(comprobante);
					nuevaOperacionEgreso.setComprobante(comprobante);
				} else {
					model.put("comprobanteUnSoloDigito", true);
					return ViewUtil.render(request, model, Path.Template.EGRESOS);
				}

				String[] fecha = getQueryFecha(request).split("/");
				try {
					LocalDate date = LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]),
							Integer.parseInt(fecha[0]));
					nuevaOperacionEgreso.setFechaOperacion(date);
				} catch (java.time.DateTimeException e) {
					model.put("errorFecha", true);
					return ViewUtil.render(request, model, Path.Template.EGRESOS);
				}
				MedioDePago mp = new MedioDePago();
				if (mp.datosDelSistema(getQueryMedio(request).trim())) {
					MedioDePagoMapperBD.getInstance().insert(mp);
					nuevaOperacionEgreso.setMedioDePago(mp);
				} else {
					model.put("errorMedioDePagoInexistente", true);
					return ViewUtil.render(request, model, Path.Template.EGRESOS);
				}
				if (getQueryDNICUITProveedor(request).trim().length() <= 8) {
					int dniPersona = Integer.parseInt(getQueryDNICUITProveedor(request).trim());
					Persona proveedorEncontradoBD = ProveedorMapperBD.getInstance().buscarPersonaPorDNI(dniPersona);
					if (proveedorEncontradoBD != null)
						nuevaOperacionEgreso.setProveedor(proveedorEncontradoBD);
					else {
						Persona nuevaPersona = new Persona();

						nuevaPersona.setDni(dniPersona);
						nuevaPersona.setNombreApellido(getQueryNombreProveedor(request).trim());
						ProveedorMapperBD.getInstance().insert(nuevaPersona);
						nuevaOperacionEgreso.setProveedor(nuevaPersona);
					}
				} else {
					int cuitProveedor = Integer.parseInt(getQueryDNICUITProveedor(request).trim());
					OrganizacionProveedora proveedorEncontradoBD = ProveedorMapperBD.getInstance()
							.buscarProveedorPorCuit(cuitProveedor);
					if (proveedorEncontradoBD != null)
						nuevaOperacionEgreso.setProveedor(proveedorEncontradoBD);
					else {
						OrganizacionProveedora nuevaOrgProveedora = new OrganizacionProveedora();
						nuevaOrgProveedora.setCuit(cuitProveedor);
						nuevaOrgProveedora.setRazonSocial(getQueryNombreProveedor(request).trim());
						ProveedorMapperBD.getInstance().insert(nuevaOrgProveedora);
						nuevaOperacionEgreso.setProveedor(nuevaOrgProveedora);
					}
				}

				OperacionEgresoMapperBD.getInstance().insert(nuevaOperacionEgreso);
				model.put("cargaEgresoExitosa", true);

			} else {
				model.put("errorDatosIncompletos", true);
				return ViewUtil.render(request, model, Path.Template.EGRESOS);
			}
		} catch (NullPointerException e) {

		}
		return ViewUtil.render(request, model, Path.Template.EGRESOS);

	};
}
