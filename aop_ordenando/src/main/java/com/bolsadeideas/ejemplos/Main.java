package com.bolsadeideas.ejemplos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

			SaludoService saludo = (SaludoService) context.getBean("saludoService");
			saludo.decirHola("Andrés Guzmán", "Buenos día!");
		}
	}
}
