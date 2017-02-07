package com.bolsadeideas.ejemplos;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SaludoServiceLoggingAspect {

    private Log log = LogFactory.getLog(this.getClass());

    // Around aspect (Alrededor) para todos los métodos invocados
    // de cualquier clase y packages
    @Around("execution(* *.*(..))")
    public Object logAlrededor(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("El método " + joinPoint.getSignature().getName()
                + "() con los parametros " + Arrays.toString(joinPoint.getArgs()));
        try {
            Object resultado = joinPoint.proceed();
            log.info("El método " + joinPoint.getSignature().getName()
                    + "() termina con " + resultado);
            return resultado;
        } catch (IllegalArgumentException e) {
            log.error("Argumento ilegal "
                    + Arrays.toString(joinPoint.getArgs()) + " en "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }

}
