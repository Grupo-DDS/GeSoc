package utn.disenio.tp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import comprasPresupuestos.Producto;
import criteriosCategorias.Categoria;
import criteriosCategorias.CriterioCategorizacion;

public class ProductoTest {

	@Test
	public void ProductoCategoria() {
		Categoria CABA = new Categoria();
		Categoria interior = new Categoria();
		Categoria mucho = new Categoria();
		
		CriterioCategorizacion ubicacion = new CriterioCategorizacion();
		CriterioCategorizacion cantidad = new CriterioCategorizacion();
		
		ubicacion.agregarCategoria(interior);
		ubicacion.agregarCategoria(CABA);
		cantidad.agregarCategoria(mucho);
		
		Producto zapatillas = new Producto("zapatillas",400);
		zapatillas.agregarCategoria(CABA);
		zapatillas.agregarCategoria(interior);
		zapatillas.agregarCategoria(mucho);
		
		assertEquals(zapatillas.categorias.size(),2);
		Categoria cat = zapatillas.categorias.get(1);
		assertEquals(cat, mucho);
	}

}
