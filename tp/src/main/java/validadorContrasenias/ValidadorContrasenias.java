package validadorContrasenias;
//package com.validarContrase�as;

import java.util.ArrayList;
public class ValidadorContrasenias{
	
	static ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
	
	static void agregarRequisitos() {
		ArchivoContraseniasInvalidas arcContInv = new ArchivoContraseniasInvalidas();
		CaracteresConsecutivos carCon = new CaracteresConsecutivos();
		CaracteresRepetidos carRep = new CaracteresRepetidos();
		CaracteresValidos carVal = new CaracteresValidos();
		LongitudValida longVal = new LongitudValida();
		
		requisitos.add(arcContInv);
		requisitos.add(carCon);
		requisitos.add(carRep);
		requisitos.add(carVal);
		requisitos.add(longVal);
	}
	
	public static boolean validar(String contrasenia){
		agregarRequisitos();
		return requisitos.stream().allMatch(requisito->requisito.validar(contrasenia)) ;
		
	}
	
	public static void imprimirResultadoValidacion(String contrasenia) {
		String mensaje= "Contraseña invalida\n";
		ArchivoContraseniasInvalidas arcContInv = new ArchivoContraseniasInvalidas();
		CaracteresConsecutivos carCon = new CaracteresConsecutivos();
		CaracteresRepetidos carRep = new CaracteresRepetidos();
		CaracteresValidos carVal = new CaracteresValidos();
		LongitudValida longVal = new LongitudValida();
		if(!longVal.validar(contrasenia))
			mensaje += "Su contraseña es demasiado corta\n";
		if(!carVal.validar(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(!arcContInv.validar(contrasenia))
			mensaje += "Su contraseña es demasiado frecuente\n ";
		if(!carRep.validar(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres repetidos\n ";
		if(!carCon.validar(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres consecutivos\n";
		if(longVal.validar(contrasenia) && carVal.validar(contrasenia)  && arcContInv.validar(contrasenia) && carRep.validar(contrasenia))
			mensaje = "Contraseña Valida";
		System.out.println(mensaje);
	}
}
	
