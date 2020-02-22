package com.desafiolatam.test.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@Column(name = "app_paterno")
	private String appPaterno;
	
	@Column(name = "app_materno")
	private String appMaterno;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy", timezone="Chile/Continental")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int edad;

	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int diasFaltantesCumple;
	
	@Transient
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String felicitaciones;
	
	public int getDiasFaltantesCumple() {
		return diasFaltantesCumple;
	}

	public void setDiasFaltantesCumple(int diasFaltantesCumple) {
		this.diasFaltantesCumple = diasFaltantesCumple;
	}

	public String getFelicitaciones() {
		return felicitaciones;
	}

	public void setFelicitaciones(String felicitaciones) {
		this.felicitaciones = felicitaciones;
	}

	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getAppPaterno() {
		return appPaterno;
	}

	public void setAppPaterno(String appPaterno) {
		this.appPaterno = appPaterno;
	}

	public String getAppMaterno() {
		return appMaterno;
	}

	public void setAppMaterno(String appMaterno) {
		this.appMaterno = appMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
