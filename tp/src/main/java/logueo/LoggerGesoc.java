package logueo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerGesoc {

	@Pointcut("within(borrar..*)")
	public void todosLosMetodosEnPaquetePersistencia() {
		System.out.println("ALGO ALGO ALGO");

	}

	@Before("todosLosMetodosEnPaquetePersistencia()")
	public void consejoPersistencia(JoinPoint jp) throws IOException {

		System.out.println("OTRA COSA");
		String str = "OTRA COSA";
		BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\java\\logueo\\archivo.txt"));
		writer.write(str);
		writer.close();
	}
}
