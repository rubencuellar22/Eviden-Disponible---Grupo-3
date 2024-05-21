package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tecnologias database table.
 * 
 */
@Entity
@Table(name="SkTechnology")
@NamedQuery(name="SkTechnology.findAll", query="SELECT t FROM SkTechnology t")
public class SkTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sktechnology")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkTechnology;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String sktechnology;

	private int nivel;





	public SkTechnology() {
	}

	public int getIdSkTechnology() {
		return idSkTechnology;
	}

	public void setIdSkTechnology(int idSkTechnology) {
		this.idSkTechnology = idSkTechnology;
	}

	public String getSktechnology() {
		return sktechnology;
	}

	public void setSktechnology(String sktechnology) {
		this.sktechnology = sktechnology;
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

	@Override
	public String toString() {
		return "SkTechnology{" +
				"idSkTechnology=" + idSkTechnology +
				", empleado=" + empleado +
				", sktechnology='" + sktechnology + '\'' +
				", nivel=" + nivel +
				'}';
	}

}