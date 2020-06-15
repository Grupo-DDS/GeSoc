package validadorContrsenias;
//package com.validarContrase�as;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArchivoContraseniasInvalidas extends Requisito{
	public boolean validar(String contraseniaInvalida) {
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