package general;

public class Producto {
	private String descripcion;
	private float valor = 0;
	
	public Producto(String descripcion, float valor) {
		super();
		this.descripcion = descripcion;
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valorIngresado) {
		this.valor = valorIngresado;
	}
}
