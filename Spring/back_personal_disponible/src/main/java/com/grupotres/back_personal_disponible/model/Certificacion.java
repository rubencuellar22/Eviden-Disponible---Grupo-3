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
	private int idCertificacion;

	@Lob
	private String certificacion;

	private boolean external;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Certificacion() {
	}

	public int getIdCertificacion() {
		return this.idCertificacion;
	}

	public void setIdCertificacion(int idCertificacion) {
		this.idCertificacion = idCertificacion;
	}

	public String getCertificacion() {
		return this.certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public boolean getExternal() {
		return this.external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Certificacion{" +
				"idCertificacion=" + idCertificacion +
				", certificacion='" + certificacion + '\'' +
				", external=" + (external ? "external" : "Internal") +
				", empleado=" + empleado +
				'}';
	}
}