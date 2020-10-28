package logueo;

public class OperacionLog {
	
	private TipoOperacion tipoOperacion; //alta, baja o modificacion
	private String entidadAfectada;
	
	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getEntidadAfectada() {
		return entidadAfectada;
	}
	public void setEntidadAfectada(String entidadAfectada) {
		this.entidadAfectada = entidadAfectada;
	}
	
}
