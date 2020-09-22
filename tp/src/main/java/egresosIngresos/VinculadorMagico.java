package egresosIngresos;

import java.util.List;

public class VinculadorMagico {
	public void vincular(){
		List<Organizacion> organizaciones = baseDeDatosDameLasOrganizaciones();
		for (Organizacion organizacion : organizaciones){
			List<OperacionIngreso> ingresos = baseDeDatosDameLosIngresosDe(organizacion);
			List<OperacionEgreso> egresos = baseDeDatosDameLosEgresosDe(organizacion);
			organizacion.getRequerimiento().vincular(ingresos, egresos);
			baseDeDatosGuardameLoQueHice(ingresos, egresos);
		}
	}
}
