package com.bolsadeideas.ejemplos;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SaludoServiceLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    @AfterReturning("execution(String SaludoService.decirHola(..))")
    public void logDespuesRetorno(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String argumentos = Arrays.toString(joinPoint.getArgs());
        log.info("DespuesRetorno: " + nombreMetodo + " invocado con los parametros " + argumentos);
    }
    
    @AfterThrowing("execution(* SaludoService.decirHola2(..))")
    public void logDespuesLanzamientoExcepcion(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String argumentos = Arrays.toString(joinPoint.getArgs());
        log.error("DespuesLanzamientoExcepcion: " + nombreMetodo + " invocado con los parametros " + argumentos);
    }

}
