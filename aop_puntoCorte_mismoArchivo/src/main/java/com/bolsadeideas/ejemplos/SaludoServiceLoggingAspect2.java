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
@Order(2)
public class SaludoServiceLoggingAspect2 {

    private Log log = LogFactory.getLog(this.getClass());
    
    @Pointcut("execution(* SaludoService.decir*(..))")
    private void holaLogging2(){}

    @Before("holaLogging2()")
    public void logAntes(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String arguments = Arrays.toString(joinPoint.getArgs());
        log.info("Antes2: " + nombreMetodo + " invocado con los parametros " + arguments);
    }
    
    @AfterReturning("holaLogging2()")
    public void logDespuesRetorno(JoinPoint joinPoint) {
    	String nombreMetodo = joinPoint.getSignature().getName();
    	String arguments = Arrays.toString(joinPoint.getArgs());
        log.info("DespuesRetorno2: " + nombreMetodo + " invocado con los parametros " + arguments);
    }
    
}
