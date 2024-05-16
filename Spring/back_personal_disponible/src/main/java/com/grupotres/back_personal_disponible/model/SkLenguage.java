package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the SkLenguage database table.
 * 
 */
@Entity
@Table(name="SkLenguage")
@NamedQuery(name="SkLenguage.findAll", query="SELECT i FROM SkLenguage i")
public class SkLenguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sklenguage")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSklenguage;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String sklenguage;

	private String nivel;



	public SkLenguage() {
	}

	public int getIdSklenguage() {
		return idSklenguage;
	}

	public void setIdSklenguage(int idSklenguage) {
		this.idSklenguage = idSklenguage;
	}

	public String getSklenguage() {
		return sklenguage;
	}

	public void setSklenguage(String sklenguage) {
		this.sklenguage = sklenguage;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
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
		return "SkLenguage{" +
				"idSklenguage=" + idSklenguage +
				", empleado=" + empleado +
				", sklenguage='" + sklenguage + '\'' +
				", nivel='" + nivel + '\'' +
				'}';
	}
}