package egresosIngresos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Requerimiento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Transient
	private IngresosEgresos restante;
	
	public IngresosEgresos vincular(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresosAVincular,
			ReglaVinculacion regla){
				IngresosEgresos ingresosEgresosOrdenados = ordenar(egresosAVincular, ingresosAVincular);
				
				int indexEgreso = 0;
				
				int sizeEgreso = ingresosEgresosOrdenados.getEgresosRestantes().size();
				
				for (OperacionIngreso ingresoAVincular: ingresosEgresosOrdenados.getIngresosRestantes()) {
					while(indexEgreso < sizeEgreso)
					{
						OperacionEgreso egresoAVincular = ingresosEgresosOrdenados.getEgresosRestantes().get(indexEgreso);
						if (regla.esVinculable(ingresoAVincular, egresoAVincular)){
							ingresosEgresosOrdenados.getEgresosRestantes().remove(indexEgreso);
							ingresoAVincular.getEgresos().add(egresoAVincular);
							egresoAVincular.setIngreso(ingresoAVincular);
							indexEgreso = 0;
							sizeEgreso = ingresosEgresosOrdenados.getEgresosRestantes().size();
							continue;
						} 
						else 
						{
							restante.getEgresosRestantes().add(egresoAVincular);
							restante.getIngresosRestantes().add(ingresoAVincular);
						}
						indexEgreso++;
					}
				}
				
				return restante;
		}
public abstract IngresosEgresos ordenar(List<OperacionEgreso> egresosAVincular, List<OperacionIngreso> ingresoAVincular);
}
