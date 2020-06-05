package general;

import java.util.Collections;
import java.util.Comparator;

public class Criterio {
public void proveedorMin(Compra compra, Mensaje mensaje) {
	Comparator <Presupuesto> comparador = new Comparator<Presupuesto>(){
		@Override
		public int compare(Presupuesto presupuesto1,Presupuesto presupuesto2) {
			if (presupuesto1.getValorTotal()>presupuesto2.getValorTotal())
				return 1;
			else
				return -1;
		}
	};
	Presupuesto presMin = Collections.min(compra.getPresupuestos(), comparador);
	boolean set = compra.getPresupuestoElegido().equals(presMin);
	mensaje.setseleccionProveedor(set);
	System.out.println(presMin);
}

}