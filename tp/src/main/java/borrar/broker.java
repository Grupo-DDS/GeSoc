package borrar;

import java.io.IOException;



public class broker {
	public void saludar() {
		System.out.println("ALOHA");
	}
	
	public static void main(String args[]) throws IOException {
		broker b = new broker();
		b.saludar();
	}
}
