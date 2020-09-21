package egresosIngresos;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrganizacionProveedora extends Proveedor{
    //hola
    int cuit;
    @Column (name = "RAZON_SOCIAL")
    String razonSocial;
}
