package app;


import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

import javax.persistence.EntityManager;

import app.persistencia.BookDao;
import app.persistencia.UserDao;
import controllers.BookController;
import controllers.EgresoController;
import controllers.IndexController;
import controllers.InicioController;
import controllers.LoginController;
import persistencia.BDUtils;

public class Application {
	
    // Declare dependencies
    public static BookDao bookDao;
    public static UserDao userDao;

    public static void main(String[] args) {
    	
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        // Dependencias del modelo o dominio
        bookDao = new BookDao();
        userDao = new UserDao();

        // Configuracion Spark
        port(8080);
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
        post(Path.Web.LOGIN,    LoginController.handleLoginPost);
        get(Path.Web.LOGOUT,   LoginController.handleLogoutPost);
        get("*",                ViewUtil.notFound);

        // Filtro aplicado despues de get y post
        after("*",              Filters.addGzipHeader);
    }

}
