package com.bolsadeideas.ejemplos.cuenta.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.ejemplos.cuenta.domain.Banco;
import com.bolsadeideas.ejemplos.cuenta.domain.Cuenta;

@Controller
@RequestMapping(value="/cuentas")
public class CuentaController {

	private Map<Long, Cuenta> cuentas = new ConcurrentHashMap<Long, Cuenta>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getAccounts(Model model) {
		
		// Agregamos algunos datos de ejemplo
		Cuenta account = new Cuenta( new Long(0001), 
				"Andrés Guzmán", 
				new BigDecimal("5000"), 
				new BigDecimal("0.30"), 
				new Date());
		
		cuentas.put(new Long(0001), account);
		
		account =  new Cuenta( new Long(0002), 
				"Bruce Lee", 
				new BigDecimal("2000"), 
				new BigDecimal("0.60"), 
				new Date());
		
		cuentas.put(new Long(0002), account);
		
		account =  new Cuenta( new Long(0003), 
				"Rod Johnson", 
				new BigDecimal("3000"), 
				new BigDecimal("0.50"), 
				new Date());
		
		cuentas.put(new Long(0003), account);
		
		// Agregamos el map de cuentas al atributo del model "cuentas", 
		// para desplegarlos en el reporte de la vista XML
		model.addAttribute("banco", new Banco("Banco Finaciero del Estado", new ArrayList<Cuenta>(cuentas.values())));
		return "cuentas";
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Cuenta cuenta = this.cuentas.get(id);
		if (cuenta == null) {
			throw new RecursoNoEncontradoException(id);
		}
		
		model.addAttribute(cuenta);
		return "cuenta";
	}

}
