package app;


import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.common.collect.ImmutableList;

import app.persistencia.BookDao;
import app.persistencia.UserDao;
import comprasPresupuestos.Presupuesto;
import comprasPresupuestos.Producto;
import controllers.AsociacionesController;
import controllers.AuditoriaController;
import controllers.BookController;
import controllers.CompraController;
import controllers.EgresoController;
import controllers.IndexController;
import controllers.IngresoController;
import controllers.InicioController;
import controllers.LoginController;
import controllers.MensajesController;
import controllers.PresupuestoController;
import controllers.ProductoController;
import controllers.ProyectoController;
import persistencia.BDUtils;
import persistencia.PresupuestoMapperBD;
import persistencia.ProductoMapperBD;

public class Application {
	
    // Declare dependencies
    public static BookDao bookDao;
    public static UserDao userDao;

    public static void main(String[] args) {
    	
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
      
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
        get(Path.Web.PROYECTO,   ProyectoController.IndexProyecto);
        get(Path.Web.VINCULAR_PROYECTO,   ProyectoController.vincularProyecto);
        get(Path.Web.CARGAR_PROYECTO,   ProyectoController.cargarProyecto);
        get(Path.Web.ASOCIACIONES,   AsociacionesController.handleAsociaciones);
        get(Path.Web.MIS_INGRESOS,  IngresoController.mis_ingresos);
        get(Path.Web.MIS_EGRESOS,  EgresoController.mis_egresos);
        get(Path.Web.AUDITORIA,  AuditoriaController.LogsView);
        get(Path.Web.COMPRA,  CompraController.cargarCompra);
        get(Path.Web.PRODUCTOS, ProductoController.cargarProducto);
        get(Path.Web.PRESUPUESTO, PresupuestoController.cargarPresupuesto);
        get(Path.Web.PRESUPUESTO_DETALLADO, PresupuestoController.cargarPresupuestoDetallado);
        get("*",                ViewUtil.notFound);

        // Filtro aplicado despues de get y post
        after("*",              Filters.addGzipHeader);
    }

}
