package com.desafiolatam.test.DTO;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UsuarioDTO {
	private String primerNombre;
	private String appPaterno;
	private int edad;
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int diasFaltantes;
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String felicitaciones;
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getAppPaterno() {
		return appPaterno;
	}
	public void setAppPaterno(String appPaterno) {
		this.appPaterno = appPaterno;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getDiasFaltantes() {
		return diasFaltantes;
	}
	public void setDiasFaltantes(int diasFaltantes) {
		this.diasFaltantes = diasFaltantes;
	}
	public String getFelicitaciones() {
		return felicitaciones;
	}
	public void setFelicitaciones(String felicitaciones) {
		this.felicitaciones = felicitaciones;
	}
}
