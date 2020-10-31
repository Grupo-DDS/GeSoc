package logueo;

import java.util.GregorianCalendar;

public class OperacionLog {
	
	private TipoOperacion tipoOperacion; //alta, baja o modificacion
	private String entidadAfectada;
	private GregorianCalendar fecha;
	
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
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
}
