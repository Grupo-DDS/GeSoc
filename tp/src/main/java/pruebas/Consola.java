package pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.API.Moneda;
import com.API.Pais;

import comprasPresupuestos.Compra;
import comprasPresupuestos.Presupuesto;
import comprasPresupuestos.PresupuestoDetallado;
import comprasPresupuestos.Producto;
import comprasPresupuestos.ProveedorMenorValor;
import egresosIngresos.DocumentoComercial;
import egresosIngresos.MedioDePago;
import egresosIngresos.OperacionEgreso;
import egresosIngresos.OperacionIngreso;
import egresosIngresos.Organizacion;
import egresosIngresos.Proveedor;
import persistencia.CompraMapperBD;
import persistencia.CriterioSeleccionPresupuestoMapperBD;
import persistencia.DocumentoComercialMapperBD;
import persistencia.MedioDePagoMapperBD;
import persistencia.MonedaMapperBD;
import persistencia.OperacionEgresoMapperBD;
import persistencia.OperacionIngresoMapperBD;
import persistencia.OrganizacionMapperBD;
import persistencia.PaisMapperBD;
import persistencia.PresupuestoDetalladoMapperBD;
import persistencia.PresupuestoMapperBD;
import persistencia.ProductoMapperBD;
import persistencia.ProveedorMapperBD;
import persistencia.UsuarioMapper;
import validadorDeCompras.Usuario;


public class Consola {
	public static void main(String args[]) throws IOException {
		
		Moneda m = new Moneda();
		MonedaMapperBD mbd = new MonedaMapperBD();
		List<Moneda> monedas = m.obtenerListaAPI();
		mbd.save(monedas);
		
		
		Pais p = new Pais();
		PaisMapperBD pbd = new PaisMapperBD();
		List<Pais> paises = p.obtenerPaises();
		List<Pais> paisesDetallados = p.obtenerPaisesDetallados(paises);
		pbd.save(paisesDetallados);
		
		Producto p1 = new Producto("Oreo",100);
		Producto p2 = new Producto("Cepillo de dientes",300);
		Producto p3 = new Producto("Botella de agua 2L",100);
		Producto p4 = new Producto("Yerba sabor frutilla",50);
		Producto p5 = new Producto("Calculadora casio",8000);
		Producto p6 = new Producto("Joystick",4000);
		Producto p7 = new Producto("Auto 9km",800000);
		Producto p8 = new Producto("Perfume",5);
		ProductoMapperBD pmBD = new ProductoMapperBD();
		pmBD.insert(p1);
		pmBD.insert(p2);
		pmBD.insert(p3);
		pmBD.insert(p4);
		pmBD.insert(p5);
		pmBD.insert(p6);
		pmBD.insert(p7);
		pmBD.insert(p8);
		
		PresupuestoDetallado pd1 = new PresupuestoDetallado(100,p1);
		PresupuestoDetallado pd2 = new PresupuestoDetallado(105640,p2);
		PresupuestoDetallado pd3 = new PresupuestoDetallado(100,p3);
		PresupuestoDetallado pd4 = new PresupuestoDetallado(105650,p4);
		PresupuestoDetallado pd5 = new PresupuestoDetallado(1033310,p5);
		PresupuestoDetallado pd6 = new PresupuestoDetallado(7100,p6);
		PresupuestoDetallado pd7 = new PresupuestoDetallado(898100,p7);
		PresupuestoDetallado pd8 = new PresupuestoDetallado(6934100,p8);		
		PresupuestoDetalladoMapperBD pdbd = new PresupuestoDetalladoMapperBD();		
		pdbd.insert(pd1);
		pdbd.insert(pd2);
		pdbd.insert(pd3);
		pdbd.insert(pd4);
		pdbd.insert(pd5);
		pdbd.insert(pd6);
		pdbd.insert(pd7);
		pdbd.insert(pd8);
		
		List<PresupuestoDetallado> detalle1 = new ArrayList<PresupuestoDetallado>();
		detalle1.add(pd1);
		detalle1.add(pd2);		
		Presupuesto pr1 = new Presupuesto(null,null,detalle1);
		
		List<PresupuestoDetallado> detalle2 = new ArrayList<PresupuestoDetallado>();
		detalle2.add(pd3);
		detalle2.add(pd4);		
		Presupuesto pr2 = new Presupuesto(null,null,detalle2);
		
		List<PresupuestoDetallado> detalle3 = new ArrayList<PresupuestoDetallado>();
		detalle3.add(pd5);
		detalle3.add(pd6);		
		Presupuesto pr3 = new Presupuesto(null,null,detalle3);
		
		List<PresupuestoDetallado> detalle4 = new ArrayList<PresupuestoDetallado>();
		detalle4.add(pd7);
		detalle4.add(pd8);		
		Presupuesto pr4 = new Presupuesto(null,null,detalle4);
		
		PresupuestoMapperBD pmbd = new PresupuestoMapperBD();
		pmbd.insert(pr1);
		pmbd.insert(pr2);
		pmbd.insert(pr3);
		pmbd.insert(pr4);
		
		
		List<Producto> productos1 = new ArrayList<Producto>();
		productos1.add(p1);
		productos1.add(p2);
		Compra c1 = new Compra(productos1,null,null,0, null,null);
		
		List<Producto> productos2 = new ArrayList<Producto>();
		productos2.add(p3);
		productos2.add(p4);
		Compra c2 = new Compra(productos2,null,null,0, null,null);
		
		List<Producto> productos3 = new ArrayList<Producto>();
		productos3.add(p5);
		productos3.add(p6);
		Compra c3 = new Compra(productos3,null,null,0, null,null);
		
		List<Producto> productos4 = new ArrayList<Producto>();
		productos4.add(p7);
		productos4.add(p8);
		Compra c4 = new Compra(productos4,null,null,0, null,null);
		
		CompraMapperBD cmbd = new CompraMapperBD();
		cmbd.insert(c1);
		cmbd.insert(c2);
		cmbd.insert(c3);
		cmbd.insert(c4);
		
		
		DocumentoComercial comprobante1=new DocumentoComercial(25,'a');
		DocumentoComercialMapperBD dcmbd = new DocumentoComercialMapperBD();
		dcmbd.insert(comprobante1);
		//Medio de pago
		MedioDePago tarjeta=new MedioDePago();
		MedioDePagoMapperBD mdpbd = new MedioDePagoMapperBD();
		tarjeta.setMedio("Visa");
		mdpbd.insert(tarjeta);
		//organizacion
		Organizacion organizacion= new Organizacion();
		OrganizacionMapperBD orgmbd = new OrganizacionMapperBD();
		orgmbd.insert(organizacion);
		//proveedores
		Proveedor proveedor1= new Proveedor();
		ProveedorMapperBD provmbd = new ProveedorMapperBD();
		provmbd.insert(proveedor1);
		//fecha operacion
		Date fechaOp=new Date();
		//productos
		Producto producto1 = new Producto("heladera",2000);
		Producto producto2 = new Producto("televisor",300);
		pmBD.insert(producto1);
		pmBD.insert(producto2);
		List<Producto> listaProducto = Arrays.asList(producto1,producto2);
		//usuarios
		ArrayList<Usuario> listaUsuariosRevisores = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario(null,null,null);
		Usuario usuario2 = new Usuario(null,null,null);
		Usuario usuario3 = new Usuario(null,null,null);
		UsuarioMapper usmbd = new UsuarioMapper();
		usmbd.insert(usuario1);
		usmbd.insert(usuario2);
		usmbd.insert(usuario3);
		listaUsuariosRevisores.add(usuario1);
		listaUsuariosRevisores.add(usuario2);
		listaUsuariosRevisores.add(usuario3);
		//criterio
		ProveedorMenorValor criterio = new ProveedorMenorValor();
		CriterioSeleccionPresupuestoMapperBD cspmbd = new CriterioSeleccionPresupuestoMapperBD();
		cspmbd.insert(criterio);
		//compra
		Compra compra1=new Compra(listaProducto, null,null, 0,listaUsuariosRevisores, criterio);
		cmbd.insert(compra1);
		//operacion egreso
		OperacionEgreso egreso1= new OperacionEgreso(comprobante1, fechaOp, tarjeta, organizacion, compra1, proveedor1);
		OperacionEgresoMapperBD oembd = new OperacionEgresoMapperBD();
		oembd.insert(egreso1);
		
		ArrayList<OperacionEgreso> egresos = new ArrayList<OperacionEgreso>();
		egresos.add(egreso1);
		OperacionIngreso ingreso1 = new OperacionIngreso("juanita", 345345346, null, egresos,new Date());
		OperacionIngresoMapperBD mapperIngreso = new OperacionIngresoMapperBD();
		mapperIngreso.insert(ingreso1);
	}
}
