package app;

import spark.Request;

public class RequestUtil {

	public static String getQueryLocale(Request request) {
		return request.queryParams("locale");
	}

	public static String getParamIsbn(Request request) {
		return request.params("isbn");
	}

	public static String getQueryUsername(Request request) {
		return request.queryParams("username");
	}

	public static String getQueryPassword(Request request) {
		return request.queryParams("password");
	}

	public static String getQueryUsernameSignin(Request request) {
		return request.queryParams("usernamesignin");
	}

	public static String getQueryPasswordSignin(Request request) {
		return request.queryParams("passwordsignin");
	}

	public static String getQueryLoginRedirect(Request request) {
		return request.queryParams("loginRedirect");
	}

	public static String getSessionLocale(Request request) {
		return request.session().attribute("locale");
	}

	public static String getSessionCurrentUser(Request request) {
		return request.session().attribute("currentUser");
	}

	public static boolean removeSessionAttrLoggedOut(Request request) {
		Object loggedOut = request.session().attribute("loggedOut");
		request.session().removeAttribute("loggedOut");
		return loggedOut != null;
	}

	public static String removeSessionAttrLoginRedirect(Request request) {
		String loginRedirect = request.session().attribute("loginRedirect");
		request.session().removeAttribute("loginRedirect");
		return loginRedirect;
	}

	public static boolean clientAcceptsHtml(Request request) {
		String accept = request.headers("Accept");
		return accept != null && accept.contains("text/html");
	}

	public static boolean clientAcceptsJson(Request request) {
		String accept = request.headers("Accept");

		return accept != null && accept.contains("application/json");
	}

	public static String getQueryCompra(Request request) {
		return request.queryParams("compra");
	}

	public static String getQueryComprobanteNumero(Request request) {
		return request.queryParams("numeroComprobante");
	}

	public static String getQueryComprobanteTipo(Request request) {
		return request.queryParams("tipoComprobante");
	}

	public static String getQueryFecha(Request request) {
		return request.queryParams("fecha");
	}
	
	public static String getQueryMedio(Request request) {
		return request.queryParams("medio");
	}
	
	public static String getQueryNombreProveedor(Request request) {
		return request.queryParams("nombreProveedor");
	}
	
	public static String getQueryDNICUITProveedor(Request request) {
		return request.queryParams("DNIoCUITprov");
	}
	public static String getQueryMontoTotal(Request request) {
		return request.queryParams("MontoTotal");
	}
	public static String getQueryDescripcion(Request request) {
		return request.queryParams("Descripcion");
	}
	
	public static String getQueryOpcionesAsociacion(Request request) {
		return request.queryParams("opcionesVinculacion");
	}
	
	public static String getQueryRegla1Mix(Request request) {
		return request.queryParams("Regla1Mix");
	}
	
	public static String getQueryRegla2Mix(Request request) {
		return request.queryParams("Regla2Mix");
	}
	
	public static String getQueryRegla3Mix(Request request) {
		return request.queryParams("Regla3Mix");
	}
	
	public static String getQueryOperaciones(Request request) {
		return request.queryParams("Operaciones");
	}
	
	public static String getQueryTipoOperacion(Request request) {
		return request.queryParams("TipoOperacion");
	}
}
