package com.bolsadeideas.ejemplos;

public class SaludoServiceImpl implements SaludoService {

	public String decirHola(String nombre, String palabraSaludo) {
        String saludo = palabraSaludo + " " + nombre;
        System.out.println(saludo);
        return saludo ;
    }

}
