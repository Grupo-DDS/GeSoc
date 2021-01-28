package controllers;


import static app.RequestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import entidades.Empresa;
import entidades.EntidadBase;
import entidades.EntidadJuridica;
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
			if(getQuery_seleccion_base_jur(request).equals("0")) {
				model.put("seleccion_base_jur_incorrecta", true);
				return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
			}
			if(getQuery_seleccion_base_jur(request).equals("1")) {
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
					if(getQuery_actividad_base_empresa(request).equals("0")) {
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
			if(getQuery_seleccion_base_jur(request).equals("2")) {
				EntidadJuridica entidad = new EntidadJuridica();
				entidad.setNombreFicticio(getQuery_nombre_ficticio_jur(request));
				Integer codigoInscripcion;
				try {
					codigoInscripcion = Integer.parseInt(getQuery_codigo_inscripcion_jur(request).trim());
				} catch (NumberFormatException e1) {
					model.put("codigoInsciripcion_jur_Incorrecto", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}
				if (codigoInscripcion < 0) {
					model.put("codigoInscripcionJurMenorACero", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}				
				Integer codigoPostal;
				try {
					codigoPostal = Integer.parseInt(getQuery_codigo_postal_jur(request).trim());
				} catch (NumberFormatException e1) {
					model.put("codigoPostal_Jur_Incorrecto", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}
				if (codigoPostal < 0) {
					model.put("codigoPostalJurMenorACero", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}				
				Integer nroCuit;
				try {
					nroCuit = Integer.parseInt(getQuery_cuit_jur(request).trim());
				} catch (NumberFormatException e1) {
					model.put("nroCuit_Jur_Incorrecto", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}
				if (nroCuit < 0) {
					model.put("nroCuitJurMenorACero", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				}
				entidad.setRazonSocial(getQuery_razon_social_jur(request));
				
				String[] entidadBaseSelec = getQuery_entidadesBaseSeleccionadas(request);
				List<EntidadBase> entidadesBase = EntidadBase.obtenerMisEntidades(entidadBaseSelec,entidadesBaseLista);
				entidad.setEntidades(entidadesBase);
				
				switch(getQuery_tipoEntidad_jur_osc_empresa(request)) {
				case "0":					
					model.put("seleccion_empresa_jur_incorrecta", true);
					return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
				case "1":					
					OSC osc = new OSC();
					entidad.setTipoDeEntidad(osc);
					break;
				case "2":					
					Empresa empresa = new Empresa();
					if(getQuery_actividad_jur_empresa(request).equals("0")) {
						model.put("seleccion_actividad_jur_incorrecta", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					empresa.setActividad(getQuery_actividad_jur_empresa(request));
					Integer cantidadPersonal;
					Integer cantidadVtasAnuales;
					try {
						cantidadPersonal = Integer.parseInt(getQuery_personal_jur_empresa(request).trim());
					} catch (NumberFormatException e1) {
						model.put("FormatoPersonal_jur_Incorrecto", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					if (cantidadPersonal < 0) {
						model.put("cantidadPersonalJurMenorACero", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					try {
						cantidadVtasAnuales = Integer.parseInt(getQuery_ventasAnuales_jur_empresa(request).trim());
					} catch (NumberFormatException e1) {
						model.put("FormatoVtasAnuales_jur_Incorrecto", true);
						return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
					}
					if (cantidadVtasAnuales < 0) {
						model.put("cantidadVtasAnualesJurMenorACero", true);
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
				EntidadJuridica.insertarNuevaJuridica(entidad);				
				model.put("Carga_de_Jur_exitosa", true);
				EntidadBase.asignarEntidadJuridica(entidad.getEntidades(), entidad);
			}

		}

		return ViewUtil.render(request, model, Path.Template.INSTANCIAR_EMPRESA);
	};

}
