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
	private int idMetodologias;

	private String metodologias;

	private int nivel;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Metodologia() {
	}

	public int getIdMetodologias() {
		return this.idMetodologias;
	}

	public void setIdMetodologias(int idMetodologias) {
		this.idMetodologias = idMetodologias;
	}

	public String getMetodologias() {
		return this.metodologias;
	}

	public void setMetodologias(String metodologias) {
		this.metodologias = metodologias;
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