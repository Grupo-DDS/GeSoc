package controllers;


import static app.JsonUtil.dataToJson;
import static app.RequestUtil.clientAcceptsHtml;
import static app.RequestUtil.clientAcceptsJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.Path;
import app.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import validadorDeCompras.Mensaje;
import validadorDeCompras.Usuario;

public class MensajesController {
    public static Route mensajesView = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            //obtencion, generacion del Modelo (MVC)
            HashMap<String, Object> model = new HashMap<>();
            String nombreUsuario = request.session().attribute("currentUser");
            Usuario usuario = Usuario.buscarUsuarioBD(nombreUsuario);
            List<Mensaje> lista = usuario.getBandejaDeMensajes();
            if(lista != null) {
            for(Mensaje mensaje : lista) {
            	
            	System.out.println("MENSAJE: "+mensaje.getCompra().getNumeroCompra()+" "+mensaje.isPresupuestoElegido());
            }}
            model.put("mensajes", usuario.getBandejaDeMensajes());
            //actualiza la Vista (MVC) que es un HTML
            return ViewUtil.render(request, model, Path.Template.MENSAJES);
        }
        
        if (clientAcceptsJson(request)) {
            //actualiza la Vista, que es un JSON
        	String nombreUsuario = request.session().attribute("currentUser");
            Usuario usuario = Usuario.buscarUsuarioBD(nombreUsuario);
            return dataToJson(usuario.getBandejaDeMensajes());
        }
        //actualiza la Vista con un mensaje de error
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
