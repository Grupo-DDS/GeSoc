package entidades;

public class Empresa extends TipoEntidad{
	int personal;
	int vtasAnuales;
	String actividad;
	
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public int getVtasAnuales() {
		return vtasAnuales;
	}
	public void setVtasAnuales(int vtasAnuales) {
		this.vtasAnuales = vtasAnuales;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
}
