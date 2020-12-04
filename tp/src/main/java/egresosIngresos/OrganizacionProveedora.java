package egresosIngresos;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrganizacionProveedora extends Proveedor {
	int cuit;
	@Column(name = "RAZON_SOCIAL")
	String razonSocial;

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

}
