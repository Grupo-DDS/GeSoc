//package validadorDeContrasenias;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;


class ArchivoContraseniasInvalidas{
	
	public static boolean encontrar(String contraseniaInvalida) {
        boolean respuesta=false;
        File archivo = null;
        FileReader lectorCaracter = null; // lee caracter a caracter
        BufferedReader lectorPalabra = null; // lee una palabra al detectar un \n

          try {                                       
             archivo = new File("contrasenias10000.txt");  
             lectorCaracter = new FileReader (archivo);           
             lectorPalabra = new BufferedReader(lectorCaracter);            
             String linea;
             while((linea=lectorPalabra.readLine())!=null)// mientras no lleguemos al final del archivo
                if(linea.contentEquals(contraseniaInvalida))
                {
                    return linea.contentEquals(contraseniaInvalida);
                }

          }
          catch(Exception e){
             e.printStackTrace();
          }finally{
             // cierra el archivo
             try{
                if( lectorCaracter !=  null ){
                   lectorCaracter.close();
                }
             }catch (Exception e2){ 
                e2.printStackTrace();
             }
          }
        return false;
       }
}
class ReguladorDeContrasenias{
	static String listaCararcteresValidos = " !\",#$%&()*+-,-./0123456789:;<=>ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`@abcdefghijklmnopqrstuvwxyz{}";
	static String mensaje= "Contrasenia invalida:\n";
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
		int cont=0;
		for(int i=0;i<contrasenia.length()-2;i++) {
			if(contrasenia.charAt(i)==contrasenia.charAt(i+1)) 
				cont++;
				else
					cont=0;
			if(cont==4)
				return true;           
		}
		return false;
	}
	
	static public void regular(String contrasenia){
		if(!longitudValida(contrasenia))
			mensaje += "Su contrasenia es demasiado corta\n";
		if(!caracteresValidos(contrasenia))
			mensaje += "Utilice caracteres validos\n";
		if(doblesEspacios(contrasenia))
			mensaje += "Los dobles espacios no son permitidos\n";
		if(contraseniaFrecuente(contrasenia))
			mensaje += "Su contrasenia es demasiado frecuente\n ";
		if(caracteresRepetidos(contrasenia))
			mensaje += "Su contraseña tiene muchos caracteres repetidos\n ";
		if(longitudValida(contrasenia) && caracteresValidos(contrasenia) && !doblesEspacios(contrasenia) && !contraseniaFrecuente(contrasenia) && !caracteresRepetidos(contrasenia))
			mensaje = "Contrasenia Valida";
		JOptionPane.showMessageDialog(null,mensaje);	
		
			
	}
}

public class Validador{
	public static void main(String[] args){
		String contrasenia = JOptionPane.showInputDialog("Ingrese su contrasenia");
		ReguladorDeContrasenias.regular(contrasenia);	 
	}	
}
