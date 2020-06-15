package validadorContrsenias;
//package com.validarContrase�as;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Validador{
	static String mensaje= "Contrase�a invalida\n";
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
	
	public static void main(String[] args){
		String contrasenia = JOptionPane.showInputDialog("Ingrese su contrase�a");
		ArchivoContraseniasInvalidas arcContInv = new ArchivoContraseniasInvalidas();
		CaracteresConsecutivos carCon = new CaracteresConsecutivos();
		CaracteresRepetidos carRep = new CaracteresRepetidos();
		CaracteresValidos carVal = new CaracteresValidos();
		LongitudValida longVal = new LongitudValida();
		if(!longVal.validar(contrasenia))
			mensaje += "Su contrase�a es demasiado corta\n";
		if(!carVal.validar(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(arcContInv.validar(contrasenia))
			mensaje += "Su contrase�a es demasiado frecuente\n ";
		if(carRep.validar(contrasenia))
			mensaje += "Su contrase�a tiene muchos caracteres repetidos\n ";
		if(carCon.validar(contrasenia))
			mensaje += "Su contrase�a tiene muchos caracteres consecutivos\n";
		if(longVal.validar(contrasenia) && carVal.validar(contrasenia)  && !arcContInv.validar(contrasenia) && !carRep.validar(contrasenia))
			mensaje = "Contrase�a Valida";
		JOptionPane.showMessageDialog(null,mensaje);
	}
}