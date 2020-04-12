import javax.swing.JOptionPane;

public class ReguladorDeContrasenias {
	static String listaCararcteresValidos = " !\",#$%&()*+-,-./0123456789:;<=>ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`@abcdefghijklmnopqrstuvwxyz{}";
	static String mensaje= "Contraseña invalida: \n";
	static public boolean longitudValida(String contrasenia){
		return contrasenia.length() >= 8;
	}
	static public boolean caracteresValidos(String contrasenia){
		int i=0;
		for(i=0;i<contrasenia.length();i++) {
			if(!listaCararcteresValidos.contains(Character.toString(contrasenia.charAt(i)))) 
				return false;
		}
		return true;
	}
	static public boolean doblesEspacios(String contrasenia){
		int i=0;
		for(i=0;i<contrasenia.length()-1;i++) {
			if(Character.isWhitespace(contrasenia.charAt(i)) && Character.isWhitespace(contrasenia.charAt(i+1))){
				return true;
			}
		}
		return false;
	}
	static public boolean contraseniaFrecuente(String contrasenia){
		return ArchivoContraseniasInvalidas.encontrar(contrasenia);
	}
	static public boolean caracteresRepetidos(String contrasenia){
		for(int i=1;i<contrasenia.length()-1;i++) {
			if(contrasenia.charAt(i)==contrasenia.charAt(i+1) && contrasenia.charAt(i)== contrasenia.charAt(i-1)) 
				return true;	           
		}
		return false;
	}
	
	
	static public void regular(String contrasenia){
		if(!longitudValida(contrasenia))
			mensaje += "Su contraseña es demasiado corta\n";
		if(!caracteresValidos(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(doblesEspacios(contrasenia))
			mensaje += "Los dobles espacios no son permitidos\n";
		if(contraseniaFrecuente(contrasenia))
			mensaje += "Su contraseña es demasiado frecuente\n ";
		if(caracteresRepetidos(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres repetidos\n ";
		if(longitudValida(contrasenia) && caracteresValidos(contrasenia) && !doblesEspacios(contrasenia) && !contraseniaFrecuente(contrasenia) && !caracteresRepetidos(contrasenia))
			mensaje = "Contraseña Valida";
		JOptionPane.showMessageDialog(null,mensaje);	
		
			
	}
}