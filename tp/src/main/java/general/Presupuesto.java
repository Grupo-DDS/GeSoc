package general;

import java.util.ArrayList;

public class Presupuesto {
	//1 presupuesto con su lista de egresos de 1 proovedor
	Proveedor proveedor;
	ArrayList<DocumentoComercial> documentosComerciales = new ArrayList<DocumentoComercial>();
	ArrayList<PresupuestoDetallado> detalles = new ArrayList<PresupuestoDetallado>();

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public ArrayList<DocumentoComercial> getDocumentosComerciales() {
		return documentosComerciales;
	}

	public void setDocumentosComerciales(ArrayList<DocumentoComercial> documentosComerciales) {
		this.documentosComerciales = documentosComerciales;
	}

	public ArrayList<PresupuestoDetallado> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<PresupuestoDetallado> detalles) {
		this.detalles = detalles;
	}

	public float getValorTotal() {
		float total = 0;
		for(PresupuestoDetallado unDetalle : detalles) { // For Each
			total += unDetalle.getPrecio();
		}
		// detalles.stream().forEach(detalle -> total += detalle.getPrecio());
		return total;
	}

	/* Esto seria Interfaz, donde se ve el detalle de los productos

	public static void mostrarDetalle() {
		for(int i = 0; i < compra.getProductos().size(); i++) {
			System.out.println(compra.getProductos().get(i).getDescripcion());
			System.out.println(compra.getProductos().get(i).getValor());
			}
	}
	 */

}
