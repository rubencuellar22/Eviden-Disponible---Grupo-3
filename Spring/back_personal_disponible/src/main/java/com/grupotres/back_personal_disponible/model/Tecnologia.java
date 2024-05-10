package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tecnologias database table.
 * 
 */
@Entity
@Table(name="tecnologias")
@NamedQuery(name="Tecnologia.findAll", query="SELECT t FROM Tecnologia t")
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tecnologias")
	private int idTecnologias;

	private int nivel;

	@Lob
	private String tecnologias;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Tecnologia() {
	}

	public int getIdTecnologias() {
		return this.idTecnologias;
	}

	public void setIdTecnologias(int idTecnologias) {
		this.idTecnologias = idTecnologias;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTecnologias() {
		return this.tecnologias;
	}

	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}