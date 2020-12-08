package app;


import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import app.persistencia.BookDao;
import app.persistencia.UserDao;
import comprasPresupuestos.Compra;
import controllers.BookController;
import controllers.EgresoController;
import controllers.IngresoController;
import controllers.IndexController;
import controllers.InicioController;
import controllers.LoginController;
import controllers.MensajesController;
import persistencia.BDUtils;
import persistencia.CompraMapperBD;
import persistencia.MensajeMapper;
import validadorDeCompras.Mensaje;
import validadorDeCompras.Usuario;

public class Application {
	
    // Declare dependencies
    public static BookDao bookDao;
    public static UserDao userDao;

    public static void main(String[] args) {
    	
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
       /* Usuario usuario = Usuario.buscarUsuarioBD("Marquitos");
        Compra compra = new Compra(); 
        
        compra.setNumeroCompra(Long.parseLong("100"));
        CompraMapperBD.getInstance().insert(compra);
        Mensaje mensaje = new Mensaje(true,true,true,compra);
        Mensaje mensaje1 = new Mensaje(true,true,true,compra);
        Mensaje mensaje2 = new Mensaje(true,true,true,compra);
        Mensaje mensaje3 = new Mensaje(true,true,true,compra);
        Mensaje mensaje4 = new Mensaje(true,true,true,compra);
        Mensaje mensaje5 = new Mensaje(true,true,true,compra);
        Mensaje mensaje6 = new Mensaje(true,true,true,compra);
        Mensaje mensaje7 = new Mensaje(true,true,true,compra);
        Mensaje mensaje8 = new Mensaje(true,true,true,compra);
        Mensaje mensaje9 = new Mensaje(true,true,true,compra);
        Mensaje mensaje10 = new Mensaje(true,true,true,compra);
        Mensaje mensaje11= new Mensaje(true,true,true,compra);
        Mensaje mensaje12 = new Mensaje(true,true,true,compra);
        Mensaje mensaje13 = new Mensaje(true,true,true,compra);
        Mensaje mensaje14 = new Mensaje(true,true,true,compra);
        ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
        mensajes.add(mensaje);
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        mensajes.add(mensaje4);
        mensajes.add(mensaje5);
        mensajes.add(mensaje6);
        mensajes.add(mensaje7);
        mensajes.add(mensaje8);
        mensajes.add(mensaje9);
        mensajes.add(mensaje10);
        mensajes.add(mensaje11);
        mensajes.add(mensaje12);
        mensajes.add(mensaje13);
        mensajes.add(mensaje14);
        MensajeMapper.getInstance().insert(mensajes);
        usuario.setBandejaDeMensajes(mensajes);*/
        bookDao = new BookDao();
        userDao = new UserDao();

        // Configuracion Spark
        port(5020);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen(); //ver una pantalla con detalle en caso de error

        // Filtro aplicado antes de get y post
        before("*",             Filters.handleLocaleChange);

        // Rutas (path, controller)
        get(Path.Web.INDEX,     IndexController.serveIndexPage);
        get(Path.Web.INICIO,     InicioController.servePaginaInicio);
        get(Path.Web.BOOKS,     BookController.fetchAllBooks);
        get(Path.Web.ONE_BOOK,  BookController.fetchOneBook);        
        get(Path.Web.LOGIN,     LoginController.serveLoginPage);
        get(Path.Web.EGRESOS,  EgresoController.cargarEgreso);
        get(Path.Web.INGRESOS,  IngresoController.cargarIngreso);
        post(Path.Web.LOGIN,    LoginController.handleLoginPost);
        get(Path.Web.LOGOUT,   LoginController.handleLogoutPost);
        get(Path.Web.MENSAJES,   MensajesController.mensajesView);
        get("*",                ViewUtil.notFound);

        // Filtro aplicado despues de get y post
        after("*",              Filters.addGzipHeader);
    }

}
