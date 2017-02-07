package com.bolsadeideas.ejemplos;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class SaludoServiceLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());
    
    // Declaramos el pointcut (punto de corte) "loggingHola"  
    @Pointcut("execution(* SaludoService.decirHola(..))")
    private void holaLogging(){}

    // Usamos el pointcut "holaLogging" en el advice (interceptor)
    @Before("holaLogging()")
    public void logAntes(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String arguments = Arrays.toString(joinPoint.getArgs());
        log.info("Antes1: " + nombreMetodo + " invocado con los parametros " + arguments);
    }
    
    // Usamos el pointcut "holaLogging" en el advice (interceptor)
    @AfterReturning("holaLogging()")
    public void logDespuesRetorno(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String arguments = Arrays.toString(joinPoint.getArgs());
        log.info("DespuesRetorno1: " + nombreMetodo + " invocado con los parametros " + arguments);
    }
    
}