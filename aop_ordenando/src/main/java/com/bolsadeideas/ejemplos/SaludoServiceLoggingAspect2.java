package com.bolsadeideas.ejemplos;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)	// Especificamos el orden
public class SaludoServiceLoggingAspect2 {

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* SaludoService.decirHola(..))")
    public void logAntes(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String arguments = Arrays.toString(joinPoint.getArgs());
        log.info("Antes2: " + nombreMetodo + " invocado con los parametros " + arguments);
    }
    
}
