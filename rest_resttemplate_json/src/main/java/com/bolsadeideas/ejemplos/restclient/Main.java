package com.bolsadeideas.ejemplos.restclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Main {
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		String testURL = "http://localhost:8080/mvc_rest_json/cuentas/{id}.json";
		
		Map<String, String> variables = new HashMap<String, String>(1);
		variables.put("id", "1");
		String jsonResult = restTemplate.getForObject(testURL,
				String.class, // tipo respuesta
				variables);	  // variables para el URI template
		System.out.println("Resultado " + jsonResult);
		
	}

}
