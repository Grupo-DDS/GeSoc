package logueo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;




@Aspect
@Component

public class LoggerGesoc {

	//@Pointcut("within(borrar..*)")
	@Pointcut(value = "execution(* *.*.inser*(..))")
	public void todosLosMetodosEnPaquetePersistencia() {

	}

	@Before(value = "todosLosMetodosEnPaquetePersistencia()", argNames = "joinPoint")
	public void consejoPersistencia(JoinPoint jp) /*throws IOException */{
		
		
		
		String str = jp.getSourceLocation().toString() + " " + 
					 jp.getStaticPart().getSignature().getName()+ " " +
					 jp.getTarget().toString()+ " " +
					 jp.getKind()+ " " +
					 jp.getSignature().getDeclaringTypeName()+" " +
					 jp.getSignature().getName() + "\n";
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("src\\main\\java\\logueo\\archivo.txt",true));
			
			writer.write(str);
		
			writer.close();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
