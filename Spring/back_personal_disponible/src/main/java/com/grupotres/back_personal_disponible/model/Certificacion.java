package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the certificaciones database table.
 * 
 */
@Entity
@Table(name="certificaciones")
@NamedQuery(name="Certificacion.findAll", query="SELECT c FROM Certificacion c")
public class Certificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_certificaciones")
	private int idCertificaciones;

	@Lob
	private String certificaciones;

	private int nivel;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Certificacion() {
	}

	public int getIdCertificaciones() {
		return this.idCertificaciones;
	}

	public void setIdCertificaciones(int idCertificaciones) {
		this.idCertificaciones = idCertificaciones;
	}

	public String getCertificaciones() {
		return this.certificaciones;
	}

	public void setCertificaciones(String certificaciones) {
		this.certificaciones = certificaciones;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}