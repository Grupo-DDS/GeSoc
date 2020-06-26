package utn.disenio.tp;

import static org.junit.Assert.*;

import org.junit.Test;

import criteriosCategorias.CriterioCategorizacion;
import validadorDeCompras.Administrador;

public class AdministradorTest {

	@Test
	public void otorgarJerarquiaTest() {
		Administrador admin= new Administrador(null, null, null);
		CriterioCategorizacion padre=new CriterioCategorizacion();
		CriterioCategorizacion hijo=new CriterioCategorizacion();
		admin.otorgarJerarquia(padre, hijo);
		assertEquals(padre.criterioHijo.get(0),hijo);
		assertEquals(hijo.criterioPadre,padre);
		
		
	}

}
