package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.quartz.SchedulerException;

import com.example.demoquartz.QuartzSchedulerCronTriggerExample;

public class Consola {
	private static ValidadorCompras validador = ValidadorCompras.getInstance();
	private static QuartzSchedulerCronTriggerExample scheduler = QuartzSchedulerCronTriggerExample.getInstance();
	public static void ejecutar() throws SchedulerException, InterruptedException{
		scheduler.comenzar();
		
		Producto producto1 = new Producto("heladera",2000);
		Producto producto2 = new Producto("televisor",300);
		Producto producto3 = new Producto("televisor",350);
		List<Producto> listaProductos = Arrays.asList(producto1,producto2,producto3);

		ArrayList<Presupuesto> listaPresupuestos = new ArrayList<Presupuesto>();
		Presupuesto presupuesto1 = new Presupuesto();
		Presupuesto presupuesto2 = new Presupuesto();
		Presupuesto presupuesto3 = new Presupuesto();

		listaPresupuestos.add(presupuesto1);
		listaPresupuestos.add(presupuesto2);
		listaPresupuestos.add(presupuesto3);

		ArrayList<Usuario> listaUsuariosRevisores = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario(null,null,null);
		Usuario usuario2 = new Usuario(null,null,null);
		Usuario usuario3 = new Usuario(null,null,null);
		Usuario usuario4 = new Usuario(null,null,null);


		listaUsuariosRevisores.add(usuario1);
		listaUsuariosRevisores.add(usuario2);
		listaUsuariosRevisores.add(usuario3);

		ProveedorMenorValor criterio = new ProveedorMenorValor();

		Compra compra = new Compra(listaProductos, listaPresupuestos,presupuesto1, 3,listaUsuariosRevisores, criterio);

		compra.agregarRevisor(usuario4);
		
		validador.notificar(compra);
		//Time.sleep(2000);
		
	}

}
