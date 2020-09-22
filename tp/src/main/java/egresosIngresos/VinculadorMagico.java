package egresosIngresos;

import java.util.List;

import persistencia.OrganizacionMapperBD;

public class VinculadorMagico {
	OrganizacionMapperBD mapOrg;
	public void vincular(){
		List<Organizacion> organizaciones = mapOrg.obtenerOrganizaciones();
		for (Organizacion organizacion : organizaciones){
			List<OperacionIngreso> ingresos = organizacion.getIngresos(); // baseDeDatosDameLosIngresosDe(organizacion);
			List<OperacionEgreso> egresos = organizacion.getEgresos(); // baseDeDatosDameLosEgresosDe(organizacion);
			ReglaVinculacion regla = organizacion.getRegla();
			organizacion.getRequerimiento().vincular(ingresos, egresos, regla);
			baseDeDatosGuardameLoQueHice(ingresos, egresos);
		}
	}
}
