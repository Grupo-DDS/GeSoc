package controllers;


import static app.RequestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import entidades.Empresa;
import entidades.EntidadBase;
import entidades.InstanciarEmpresa;
import entidades.OSC;
import spark.Request;
import spark.Response;
import spark.Route;

public class InstanciarEmpresaController {
	public static Route instanciarEmpresa = (Request request, Response response) -> {
		Map<String, Object> model = new HashMap<>();
		List<EntidadBase> entidadesBaseLista = EntidadBase.obtenerTodosSinAsignar();
		model.put("entidadesBaseLista", entidadesBaseLista);
		//LoginController.ensureUserIsLoggedIn(request, response);
		if(getQuery_seleccion_base_jur(request)!=null) {
			if(getQuery_seleccion_base_jur(request)=="0") {
				model.put("seleccion_base_jur_incorrecta", true);
				return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
			}
			if(getQuery_seleccion_base_jur(request)=="1") {
				EntidadBase entidad = new EntidadBase();
				entidad.setNombreFicticio(getQuery_nombre_ficticio_base(request));
				entidad.setDescripcion(getQuery_descripcion_base(request));
				switch(getQuery_tipoEntidad_base_osc_empresa(request)) {
				case "0":					
					model.put("seleccion_empresa_base_incorrecta", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				case "1":					
					OSC osc = new OSC();
					entidad.setTipoDeEntidad(osc);
					break;
				case "2":					
					Empresa empresa = new Empresa();
					if(getQuery_actividad_base_empresa(request)=="0") {
						model.put("seleccion_actividad_base_incorrecta", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					empresa.setActividad(getQuery_actividad_base_empresa(request));
					Integer cantidadPersonal;
					Integer cantidadVtasAnuales;
					try {
						cantidadPersonal = Integer.parseInt(getQuery_personal_base_empresa(request).trim());
					} catch (NumberFormatException e1) {
						model.put("FormatoPersonal_base_Incorrecto", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					if (cantidadPersonal < 0) {
						model.put("cantidadPersonalBaseMenorACero", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					try {
						cantidadVtasAnuales = Integer.parseInt(getQuery_ventasAnuales_base_empresa(request).trim());
					} catch (NumberFormatException e1) {
						model.put("FormatoVtasAnuales_base_Incorrecto", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					if (cantidadVtasAnuales < 0) {
						model.put("cantidadVtasAnualesBaseMenorACero", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					empresa.setPersonal(cantidadPersonal);
					empresa.setVtasAnuales(cantidadVtasAnuales);
					InstanciarEmpresa.definirEmpresa(empresa);
					entidad.setTipoDeEntidad(empresa);
					break;
				default:

					break;
				}
				EntidadBase.insertarNuevaBase(entidad);
				model.put("Carga_de_Base_exitosa", true);
			}
			if(getQuery_seleccion_base_jur(request)=="2") {

			}

		}

		return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
	};

}
