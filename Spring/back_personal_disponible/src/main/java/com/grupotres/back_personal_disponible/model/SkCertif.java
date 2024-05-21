package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the certificaciones database table.
 * 
 */
@Entity
@Table(name="SkCertif")
@NamedQuery(name="SkCertif.findAll", query="SELECT c FROM SkCertif c")
public class SkCertif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_skcertif")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSkCertif;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String skcertif;

	private boolean external;



	public SkCertif() {
	}

	public int getIdSkCertif() {
		return idSkCertif;
	}

	public void setIdSkCertif(int idSkCertif) {
		this.idSkCertif = idSkCertif;
	}

	public String getSkcertif() {
		return skcertif;
	}

	public void setSkcertif(String skcertif) {
		this.skcertif = skcertif;
	}

	public boolean isExternal() {
		return external;
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
		return "SkCertif{" +
				"idSkCertif=" + idSkCertif +
				", empleado=" + empleado +
				", skcertif='" + skcertif + '\'' +
				", external=" + external +
				'}';
	}
}