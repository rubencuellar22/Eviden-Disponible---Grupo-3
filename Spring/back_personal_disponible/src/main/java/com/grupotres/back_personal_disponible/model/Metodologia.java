package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the metodologias database table.
 * 
 */
@Entity
@Table(name="metodologias")
@NamedQuery(name="Metodologia.findAll", query="SELECT m FROM Metodologia m")
public class Metodologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_metodologias")
	private int idMetodologia;

	private String metodologia;

	private int nivel;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Metodologia() {
	}

	public int getIdMetodologia() {
		return this.idMetodologia;
	}

	public void setIdMetodologia(int idMetodologia) {
		this.idMetodologia = idMetodologia;
	}

	public String getMetodologia() {
		return this.metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
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
		return "Metodologia{" +
				"idMetodologia=" + idMetodologia +
				", metodologia='" + metodologia + '\'' +
				", nivel=" + nivel +
				", empleado=" + empleado +
				'}';
	}
}