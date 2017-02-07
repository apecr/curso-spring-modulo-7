package com.bolsadeideas.ejemplos;

public class SaludoServiceImpl implements SaludoService {

	// Este metodo retona el saludo sin problema
	public String decirHola(String nombre, String palabraSaludo) {
        String saludo = palabraSaludo + " " + nombre;
        System.out.println(saludo);
        return saludo;
    }
	
	// Este metodo lanza una excepcion
	public String decirHola2(String nombre, String palabraSaludo) {
        String saludo = palabraSaludo + " " + nombre;
        System.out.println(saludo);
		throw new IllegalArgumentException();
    }

}
