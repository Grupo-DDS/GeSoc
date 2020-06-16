package utn.disenio.tp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import general.Compra;
import general.DocumentoComercial;
import general.MedioDePago;
import general.OperacionEgreso;
import general.Organizacion;
import general.Presupuesto;
import general.Producto;
import general.Proveedor;
import general.ProveedorMenorValor;
import general.Usuario;

public class OperacionEgresoTest {

	@Test
	public void validarOperacionEgreso() {
		//Documento Comercial
		DocumentoComercial comprobante1=new DocumentoComercial();
		//Medio de pago
		MedioDePago tarjeta=new MedioDePago();
		tarjeta.setMedio("Visa");
		//organizacion
		Organizacion organizacion= new Organizacion();
		//proveedores
		Proveedor proveedor1= new Proveedor();
		//fecha operacion
		Date fechaOp=new Date();
		//productos
		Producto producto1 = new Producto("heladera",2000);
		Producto producto2 = new Producto("televisor",300);
		List<Producto> listaProducto = Arrays.asList(producto1,producto2);
		//presupuestos
		ArrayList<Presupuesto> listaPresupuestos = new ArrayList<Presupuesto>();
		Presupuesto presupuesto1 = new Presupuesto();
		Presupuesto presupuesto2 = new Presupuesto();
		Presupuesto presupuesto3 = new Presupuesto();
		
		listaPresupuestos.add(presupuesto1);
		listaPresupuestos.add(presupuesto2);
		listaPresupuestos.add(presupuesto3);
		//usuarios
		ArrayList<Usuario> listaUsuariosRevisores = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		
		listaUsuariosRevisores.add(usuario1);
		listaUsuariosRevisores.add(usuario2);
		listaUsuariosRevisores.add(usuario3);
		//criterio
		ProveedorMenorValor criterio = new ProveedorMenorValor();
		//compra
		Compra compra1=new Compra(listaProducto, listaPresupuestos,presupuesto1, 3,listaUsuariosRevisores, criterio);
		//operacion egreso
		OperacionEgreso egreso1= new OperacionEgreso(comprobante1, fechaOp, tarjeta, organizacion, compra1, proveedor1);
		//TESTS
		assertTrue(egreso1.getComprobante()==comprobante1);
        assertTrue(egreso1.getFechaOperacion()==fechaOp);
        assertTrue(egreso1.getMedioDePago()==tarjeta);
        assertTrue(egreso1.getOrganizacion()==organizacion);
        assertTrue(egreso1.getProveedor()==proveedor1);
        assertTrue(egreso1.getValorDeEgreso()==compra1.getPresupuestoElegido().getValorTotal());
	}
}
