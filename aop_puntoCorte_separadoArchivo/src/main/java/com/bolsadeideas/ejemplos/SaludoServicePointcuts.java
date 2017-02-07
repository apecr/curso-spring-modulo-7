package com.bolsadeideas.ejemplos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SaludoServicePointcuts {
    
    @Pointcut("execution(* SaludoService.decirHola(..))")
    public void holaLogging(){}
    
    @Pointcut("execution(* SaludoService.decir*(..))")
    public void holaLogging2(){}
    
}