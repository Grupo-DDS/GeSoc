package validadorContrsenias;
//package com.validarContrase�as;
import javax.swing.JOptionPane;

public class Validador{
	static String mensaje= "Contrase�a invalida\n";
	
	public static void main(String[] args){
		String contrasenia = JOptionPane.showInputDialog("Ingrese su contrase�a");
		
		if(!LongitudValida.validar(contrasenia))
			mensaje += "Su contrase�a es demasiado corta\n";
		if(!CaracteresValidos.validar(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(ArchivoContraseniasInvalidas.validar(contrasenia))
			mensaje += "Su contrase�a es demasiado frecuente\n ";
		if(CaracteresRepetidos.validar(contrasenia))
			mensaje += "Su contrase�a tiene muchos caracteres repetidos\n ";
		if(CaracteresConsecutivos.validar(contrasenia))
			mensaje += "Su contrase�a tiene muchos caracteres consecutivos\n";
		if(LongitudValida.validar(contrasenia) && CaracteresValidos.validar(contrasenia)  && !ArchivoContraseniasInvalidas.validar(contrasenia) && !CaracteresRepetidos.validar(contrasenia))
			mensaje = "Contrase�a Valida";
		JOptionPane.showMessageDialog(null,mensaje);
	}
}