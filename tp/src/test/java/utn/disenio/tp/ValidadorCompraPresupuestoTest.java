package utn.disenio.tp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import general.Compra;
import general.Criterio;
import general.Presupuesto;
import general.Producto;
import general.ProveedorMenorValor;
import general.Usuario;
import general.ValidadorCompras;

public class ValidadorCompraPresupuestoTest {

	
	@Test
	public void cantidadYEleccionTest() {
		fail("Not yet implemented");
		
		List<Producto> listaProducto = new ArrayList<Producto>();
		ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
		Presupuesto presupuesto1 = new Presupuesto();
		Presupuesto presupuesto2 = new Presupuesto();
		Presupuesto presupuesto3 = new Presupuesto();
		
		presupuestos.add(presupuesto1);
		presupuestos.add(presupuesto2);
		presupuestos.add(presupuesto3);
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		Usuario usuario4 = new Usuario();
		
		
		
		ArrayList<Usuario> revisores = new ArrayList<Usuario>();
		revisores.add(usuario1);
		revisores.add(usuario2);
		revisores.add(usuario3);
		revisores.add(usuario4);
		ProveedorMenorValor criterio = new ProveedorMenorValor();
		
		
		Compra compra = new Compra(listaProducto, presupuestos,presupuesto1, 3,revisores, criterio);
		
		ValidadorCompras.validar(compra);
		assertTrue(ValidadorCompras.verificarCantidad(compra));
		assertTrue(ValidadorCompras.verificarPresupuestoElegido(compra));
		
		
	}

}
