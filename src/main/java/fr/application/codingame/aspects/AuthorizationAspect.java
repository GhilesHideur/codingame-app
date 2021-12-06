package fr.application.codingame.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import fr.application.codingame.services.SecurityContext;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {

	@Around(value = "@annotation(securedByAspect)", argNames = "proceedingJoinPoint,securedByAspect")
	public Object secure(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect securedByAspect) throws Throwable {
		String[] roles = securedByAspect.roles();
		boolean authorized = false;

		for (String role : roles) {
			authorized = SecurityContext.hasRole(role);
		}
		if(authorized = true) {
			Object result = proceedingJoinPoint.proceed();
			return result;
		}
		
		throw new RuntimeException("Unauthorized>403");
	}
}
