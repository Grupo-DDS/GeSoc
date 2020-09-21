package persistencia;

import comprasPresupuestos.Compra;


public class CompraMapperBD extends SuperBDUtilsRodriCapo<Compra>{

	public void rodriEsUnLindo(Compra c) {
		this.insert(c);
	}
	/*
	 En las clases mapper NO VA LOGICA DE NEGOCIO. 
	 Solo va LOGICA DE BD (Accion de crear, borrar, actualizar registros).
	 
	 
	 
	 */
	
}