package fr.application.codingame.aspects;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {

	Logger logger = Logger.getLogger(LogAspect.class.getName());

	public LogAspect() throws IOException {
		this.logger.addHandler(new FileHandler("log.xml"));
		logger.setUseParentHandlers(false);
	}
	

	@Around(value = "@annotation(fr.application.codingame.aspects.Log)")
	public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		long t1 = System.currentTimeMillis();

		Object result = proceedingJoinPoint.proceed();

		long t2 = System.currentTimeMillis();

		logger.info(String.format("***************** Duration : %d ms *********************", t2 - t1));

		return result;
	}

}
