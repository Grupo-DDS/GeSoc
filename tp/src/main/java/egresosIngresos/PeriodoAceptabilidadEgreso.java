package egresosIngresos;
import java.util.Date;

public class PeriodoAceptabilidadEgreso {
public Date fechaInicio;
public Date fechaFin;

public Date getFechaInicioPeriodo() {
	return fechaInicio;
}
public void setFechaInicioPeriodo(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
}

public Date getFechaFinPeriodo() {
	return fechaFin;
}
public void setFechaFinPeriodo(Date fechaFin) {
	this.fechaFin = fechaFin;
}
}
