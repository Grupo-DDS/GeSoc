package com.validadorEgresos;

public class InstanciarEmpresa {
	// Matriz de Cantidad  [TipoEmpresa,Actividad]
	static int matrizXpersonal [][]  = {{12,7,7,15,5},{45,30,35,60,10},{200,165,125,235,50},{590,535,345,655,215}};
	static int matrizXventasAnuales [][] = {{15230000,8500000,29740000,26540000,12890000},{90310000,50950000,178860000,190410000,48480000},{503880000,425170000,1502750000,1190330000,345430000},{755740000,607210000,2146810000,1739590000,547890000}};
	static int tipo;
	static int tipo2; 
	
	public void definirEmpresa(Empresa empresa) {
		switch(empresa.actividad) {
		case "CONSTRUCCION":
			definirEmpresaXactividad(0, empresa);
			break;
		case "SERVICIOS":
			definirEmpresaXactividad(1, empresa);
			break;
		case "COMERCIO":
			definirEmpresaXactividad(2, empresa);
			break;
		case "INDUSTRIAyMINERIA":
			definirEmpresaXactividad(3, empresa);
			break;
		case "AGROPECUARIO":
			definirEmpresaXactividad(4, empresa);
			break;
		default:
			System.out.println("No es una actividad registrada");
		}
	}
	
	public static void definirEmpresaXactividad(int actividad,Empresa empresa) {
	tipo = buscarTipoEmpresaXpersonal(actividad,empresa);
	tipo2 = buscarTipoEmpresaXventas(actividad,empresa);			
	if(tipo == tipo2)
		instanciar(tipo);
	}
	
	public static void instanciar(int valor) {
		switch(valor) {
		case 0:
			new Micro();
			break;
		case 1:
			new Pequenia();
			break;
		case 2:
			new MedianaTramo1();
			break;
		case 3:
			new MedianaTramo2();
			break;
		}
	}
	
	public static int buscarTipoEmpresaXpersonal(int n,Empresa empresa) {
		int i = 0;
		if(empresa.personal > matrizXpersonal[i][n])
			i++;
		return i;
	}
	
	public static int buscarTipoEmpresaXventas(int n,Empresa empresa) {
		int i = 0;
		if(empresa.vtasAnuales > matrizXventasAnuales[i][n])
			i++;
		return i;
	}
}