package com.bolsadeideas.ejemplos;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SaludoServiceLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    // Invocado Antes del metodo String SaludoService.decirHola(..)
    // intercepta el advice, logAntes(..).
    @Before("execution(String SaludoService.decirHola(..))")
    public void logAntes(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String argumentos = Arrays.toString(joinPoint.getArgs());
        log.info("Antes: " + nombreMetodo + " con los parametros " + argumentos);
    }
    
}
