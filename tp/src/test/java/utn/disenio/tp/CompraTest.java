package utn.disenio.tp;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import general.Compra;
import general.Producto;

/**
 * Unit test for simple App.
 */
public class CompraTest 
{
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue()
	{
		assertTrue(true);
	}
	
	@Test
	public void validarCalcularTotal() {
		Producto producto1 = new Producto("heladera",2000);
		Producto producto2 = new Producto("televisor",300);
		List<Producto> listaProducto = Arrays.asList(producto1,producto2); //me arma la lista d1
		/*
		ArrayList<Producto> listaProducto = new ArrayList<Producto>();
		listaProducto.add(producto1);
		listaProducto.add(producto2);
		*/
		Compra compra = new Compra(listaProducto,null,null,0,null,null);
		assertTrue(compra.getValorTotal() == 2300);
	}
}
