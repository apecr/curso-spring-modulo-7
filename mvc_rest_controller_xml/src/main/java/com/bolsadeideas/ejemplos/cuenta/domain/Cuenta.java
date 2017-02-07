package com.bolsadeideas.ejemplos.cuenta.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@XmlRootElement(name = "cuenta")
public class Cuenta {

	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	private String nombre;

	@NotNull
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal saldo = new BigDecimal("5500");

	@NotNull
	@NumberFormat(style = Style.PERCENT)
	private BigDecimal nivelEndeudamiento = new BigDecimal(".05");

	@DateTimeFormat(style = "S-")
	@Future
	private Date fechaRenovacion = new Date(new Date().getTime() + 21425000000L);

	public Cuenta() {
	}

	public Cuenta(Long id, String nombre, BigDecimal saldo,
			BigDecimal nivelEndeudamiento, Date fechaRenovacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.nivelEndeudamiento = nivelEndeudamiento;
		this.fechaRenovacion = fechaRenovacion;
	}
	
	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getNivelEndeudamiento() {
		return nivelEndeudamiento;
	}

	public void setNivelEndeudamiento(BigDecimal nivelEndeudamiento) {
		this.nivelEndeudamiento = nivelEndeudamiento;
	}

	public Date getFechaRenovacion() {
		return fechaRenovacion;
	}

	public void setFechaRenovacion(Date fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}

}