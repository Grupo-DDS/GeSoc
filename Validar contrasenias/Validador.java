package com.validarContraseñas;
import javax.swing.JOptionPane;

public class Validador{
	static String mensaje= "Contraseña invalida\n";
	
	public static void main(String[] args){
		String contrasenia = JOptionPane.showInputDialog("Ingrese su contraseña");
		
		if(!LongitudValida.validar(contrasenia))
			mensaje += "Su contraseña es demasiado corta\n";
		if(!CaracteresValidos.validar(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(ArchivoContraseniasInvalidas.validar(contrasenia))
			mensaje += "Su contraseña es demasiado frecuente\n ";
		if(CaracteresRepetidos.validar(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres repetidos\n ";
		if(CaracteresConsecutivos.validar(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres consecutivos\n";
		if(LongitudValida.validar(contrasenia) && CaracteresValidos.validar(contrasenia)  && !ArchivoContraseniasInvalidas.validar(contrasenia) && !CaracteresRepetidos.validar(contrasenia))
			mensaje = "Contraseña Valida";
		JOptionPane.showMessageDialog(null,mensaje);
	}
}