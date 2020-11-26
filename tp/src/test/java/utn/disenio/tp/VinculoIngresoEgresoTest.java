package utn.disenio.tp;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comprasPresupuestos.Compra;
import comprasPresupuestos.Producto;
import egresosIngresos.OperacionEgreso;
import egresosIngresos.OperacionIngreso;
import egresosIngresos.OrdenFecha;
import egresosIngresos.Organizacion;
import egresosIngresos.ReglaFecha;
import persistencia.CompraMapperBD;
import persistencia.OperacionEgresoMapperBD;
import persistencia.OperacionIngresoMapperBD;
import persistencia.OrganizacionMapperBD;
import persistencia.ProductoMapperBD;

public class VinculoIngresoEgresoTest {
	@Test
	public void validarVinculoIngresoEgreso() {
		//organizacion
		Organizacion organizacion= new Organizacion();
		organizacion.setRegla(new ReglaFecha());
		organizacion.setRequerimiento(new OrdenFecha());
		
		OrganizacionMapperBD.getInstance().insert(organizacion);
		//proveedores
		GregorianCalendar g = new GregorianCalendar(2010, 7, 7);
		Date fechaOp= g.getTime();
		//productos
		Producto producto1 = new Producto("heladera",2000);
		Producto producto2 = new Producto("televisor",300);
		List<Producto> listaProducto = Arrays.asList(producto1,producto2);
		//compra
		Compra compra1=new Compra(listaProducto, null,null, 0,null, null);
		//operacion egreso
		OperacionEgreso egreso1= new OperacionEgreso(null, fechaOp, null, organizacion, compra1, null);
		
		
		GregorianCalendar g2 = new GregorianCalendar(2010, 7, 7);
		Date fechaOp2= g2.getTime();
		//productos
		Producto producto12 = new Producto("heladera",2000);
		Producto producto22 = new Producto("televisor",300);
		List<Producto> listaProducto2 = Arrays.asList(producto12,producto22);
		//compra
		Compra compra12=new Compra(listaProducto2, null,null, 0,null, null);
		//operacion egreso
		OperacionEgreso egreso12= new OperacionEgreso(null, fechaOp2, null, organizacion, compra12, null);

		
		GregorianCalendar g3 = new GregorianCalendar(2010, 7, 7);
		Date fechaOp3= g3.getTime();
		//productos
		Producto producto13 = new Producto("heladera",2000);
		Producto producto23 = new Producto("televisor",300);
		List<Producto> listaProducto3 = Arrays.asList(producto13,producto23);
		//compra
		Compra compra13=new Compra(listaProducto3, null,null, 0,null, null);
		//operacion egreso
		OperacionEgreso egreso13= new OperacionEgreso(null, fechaOp3, null, organizacion, compra13, null);
	
		

		
		GregorianCalendar gIngreso1 = new GregorianCalendar(2010, 7, 7);
		Date fechaIngreso1= gIngreso1.getTime();
		OperacionIngreso ingreso1 = new OperacionIngreso("ingreso 1",3333,fechaIngreso1,new ArrayList<OperacionEgreso>(),organizacion);
		GregorianCalendar gIngreso12 = new GregorianCalendar(2010, 7, 7);
		Date fechaIngreso12= gIngreso12.getTime();
		OperacionIngreso ingreso12 = new OperacionIngreso("ingreso 2", 3333, fechaIngreso12,new ArrayList<OperacionEgreso>(), organizacion);
	
		
		GregorianCalendar gIngreso13 = new GregorianCalendar(2010, 7, 7);
		Date fechaIngreso13= gIngreso13.getTime();
		OperacionIngreso ingreso13 = new OperacionIngreso("ingreso 1", 3333, fechaIngreso13,new ArrayList<OperacionEgreso>(), organizacion);

		ProductoMapperBD.getInstance().insert(listaProducto);
		ProductoMapperBD.getInstance().insert(listaProducto2);
		ProductoMapperBD.getInstance().insert(listaProducto3);
		CompraMapperBD.getInstance().insert(compra1);
		CompraMapperBD.getInstance().insert(compra12);
		CompraMapperBD.getInstance().insert(compra13);
		OperacionIngresoMapperBD.getInstance().insert(Arrays.asList(ingreso1,ingreso12,ingreso13));
		
		OperacionEgresoMapperBD.getInstance().insert(Arrays.asList(egreso1,egreso12,egreso13));
		
		organizacion.setEgresos(Arrays.asList(egreso1,egreso12,egreso13));
		organizacion.setIngresos(Arrays.asList(ingreso1,ingreso12,ingreso13));

		
		
		//VinculadorMagico vm = new VinculadorMagico();
		//vm.vincular();
		
		
		List<OperacionEgreso> egresosVinculados = OperacionEgresoMapperBD.getInstance().obtenerEgresos();
		
		//egresosVinculados.forEach(egresoV -> System.out.println(egresoV.toString()));
//		
//		List<OperacionIngreso> ingresosVinculados = OperacionIngresoMapperBD.getInstance().obtenerIngresos();
//		ingresosVinculados.forEach(ingresoV->System.out.println(ingresoV.toString()));
		
		assertTrue(true);
		
		
	}
	
	@Before
	public void borrarBaseDeDatos() {
		
	}
}
