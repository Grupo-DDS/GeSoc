package utn.disenio.tp;
import static org.junit.Assert.*;

import org.junit.Test;

import comprasPresupuestos.Presupuesto;
import comprasPresupuestos.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import egresosIngresos.Organizacion;
import egresosIngresos.Requerimiento;
import egresosIngresos.OrdenValorPrimeroEgreso;
import egresosIngresos.OrdenValorPrimeroIngreso;
import egresosIngresos.OrdenFecha;
import egresosIngresos.OrdenMix;
import egresosIngresos.PeriodoAceptabilidadEgreso;
import egresosIngresos.VinculoIngresoEgreso;
import egresosIngresos.OperacionEgreso;
import egresosIngresos.OperacionIngreso;

public class requerimientoTest {
	Date fecha1 = new Date(112,7,7,18,25,12);
	Date fecha2 = new Date(117,7,7,18,25,12);
	Date fechaEgreso1 = new Date(114,7,7,18,25,12);
	Date fechaEgreso2 = new Date(115,7,7,18,25,12);
	Date fechaEgreso3 = new Date(116,7,7,18,25,12);
	PeriodoAceptabilidadEgreso periodo = new PeriodoAceptabilidadEgreso(fecha1, fecha2);
	OperacionEgreso egreso1 = new OperacionEgreso(null, fechaEgreso1, null, null, null, null);
	OperacionEgreso egreso2 = new OperacionEgreso(null, fechaEgreso3, null, null, null, null);
	OperacionEgreso egreso3 = new OperacionEgreso(null, fechaEgreso2, null, null, null, null);
	OperacionIngreso ingreso1 = new OperacionIngreso(null, 1000, periodo);
	OperacionIngreso ingreso2 = new OperacionIngreso(null, 2000, periodo);
	OperacionIngreso ingreso3 = new OperacionIngreso(null, 3000, periodo);
	List<OperacionIngreso> ingresos = Arrays.asList(ingreso1,ingreso2,ingreso3);
	List<OperacionEgreso> egresos = Arrays.asList(egreso1,egreso2,egreso3);
	
	Organizacion organizacion = new Organizacion(null, ingresos, egresos);
 @Test
 public void testearOrdenValorPrimeroEgreso(){
	 
 }
 
 @Test
 public void testearOrdenValorPrimeroIgreso(){
	 
 }
 
 @Test
 public void testearOrdenFecha(){
	 
 }
 
 @Test
 public void testearOrdenMix(){
	 
 }
	
}
