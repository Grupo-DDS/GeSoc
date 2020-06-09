package general;

import java.util.ArrayList;

public class Presupuesto {
	 //1 presupuesto con su lista de egresos de 1 proovedor
	static OperacionEgreso egreso;
	ArrayList<DocumentoComercial> documentosComerciales = new ArrayList<DocumentoComercial>();
	float valorTotal = egreso.getValorDeEgreso();
	ArrayList<Producto> detalle = egreso.getProductos();
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public static void mostrarDetalle() {
		for(int i = 0; i < egreso.getProductos().size(); i++) {
			System.out.println(egreso.getProductos().get(i).getDescripcion());
			System.out.println(egreso.getProductos().get(i).getValor());
			}
	}
		
}
