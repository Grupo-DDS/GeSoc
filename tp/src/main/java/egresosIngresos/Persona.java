package egresosIngresos;

import javax.persistence.Entity;

@Entity
public class Persona extends Proveedor {
	int dni;
	String nombreApellido;
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

}
