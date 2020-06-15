package general;

import java.util.Collections;
import java.util.Comparator;

public class ProveedorMenorValor extends Criterio {

	public Presupuesto obtenerPresupuesto(Compra compra) {
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
		return presMin;

	}
}
