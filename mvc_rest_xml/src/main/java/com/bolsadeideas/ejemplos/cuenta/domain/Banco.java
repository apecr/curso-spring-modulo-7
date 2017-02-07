package com.bolsadeideas.ejemplos.cuenta.domain;

import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "banco")
public class Banco {
 
	private String classId = null;
	private List<Cuenta> cuentas = null;
 
	public Banco() {}
 
	public Banco(String id, List<Cuenta> cuentas) {
		this.classId = id;
		this.cuentas = cuentas;
	}
 
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
 
	@XmlElement(name="cuentas")
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
 
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}